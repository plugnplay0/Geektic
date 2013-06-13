package geektic.controller;

import geektic.service.InteretService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/accueil")
public class InteretController {

	@Autowired
	InteretService interetService;
	
	public InteretController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listerInterets() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Accueil");
		mav.addObject("interets", interetService.listerTous());
		return mav;
	}
	
}
