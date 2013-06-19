package geektic.controller;

import geektic.model.Geek;
import geektic.service.GeekService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/profil")
public class ProfilController {

	@Autowired
	GeekService geekService;
	
	public ProfilController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET, params="geekId")
	public ModelAndView afficherProfil(@RequestParam("geekId") long geekId) {
		Geek geek = geekService.trouverParId(geekId);
		long nbConsults = geekService.trouverNombreConsults(geekId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Profil");
		mav.addObject(geek);
		mav.addObject("nbConsults", nbConsults);
		return mav;
	}
	
}
