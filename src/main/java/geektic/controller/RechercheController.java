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
	
	@RequestMapping(method = RequestMethod.GET, params={"pseudo", "nom", "prenom", "sexe", "agemin", "agemax", "interet1", "interet2", "interet3"})
	public ModelAndView listerGeeks(
			@RequestParam("pseudo") String pseudo,
			@RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom,
			@RequestParam("agemin") int agemin,
			@RequestParam("sexe") String sexe,
			@RequestParam("agemax") int agemax,
			@RequestParam("interet1") long interet1,
			@RequestParam("interet2") long interet2,
			@RequestParam("interet3") long interet3)
	{
		List<Geek> liste = geekService.trouverParSexe(sexe);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Resultat");
		mav.addObject("geeks", liste);
		return mav;
	}
	
}
