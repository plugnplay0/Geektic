package geektic.controller;

import geektic.service.GeekService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/profil")
public class GeekController {

	@Autowired
	GeekService geekService;
	
	public GeekController() {
		
	}
	
}
