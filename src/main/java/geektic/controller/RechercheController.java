package geektic.controller;

import geektic.model.Geek;
import geektic.service.GeekService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/accueil/rechercher")
public class RechercheController {

	@Autowired
	GeekService geekService;
	
	public RechercheController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET, params="sexe")
	public ModelAndView listerGeeks(@RequestParam("sexe") String sexe) {
		List<Geek> liste = geekService.trouverParSexe(sexe);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Resultat");
		mav.addObject("geeks", liste);
		return mav;
	}
	
}
