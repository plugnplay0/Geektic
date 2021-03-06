package geektic.controller;

import geektic.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/accueil")
public class AccueilController {

	@Autowired
	TypeService typeService;
	
	public AccueilController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listerInterets() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Accueil");
		mav.addObject("types", typeService.listerTous());
		return mav;
	}
	
}