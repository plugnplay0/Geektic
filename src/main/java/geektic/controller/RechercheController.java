 package geektic.controller;

import geektic.model.Geek;
import geektic.service.GeekService;
import geektic.service.InteretService;

import java.util.ArrayList;
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
	
	@Autowired
	InteretService interetService;
	
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
		// Filtrer tous les geeks r�pondant aux crit�res de nom, pr�nom, sexe, �ge min et �ge max
		List<Geek> liste = geekService.trouverSelonCriteres(pseudo, nom, prenom, sexe, agemin, agemax);
		
		// Filtrer tous les geeks r�pondant aux crit�res de centres d'int�r�t
		List<Geek> listeCI = new ArrayList<Geek>();
		if(interet1 != 0) {
			listeCI = (interetService.trouverParId(interet1)).getGeeks();
		}
		if(interet2 != 0) {
			listeCI.addAll((interetService.trouverParId(interet2)).getGeeks());
		}
		if(interet2 != 0) {
			listeCI.addAll((interetService.trouverParId(interet3)).getGeeks());
		}
		
		// Ne conserver que l'intersection des deux ensembles
		if(listeCI.size() > 0) {
			liste.retainAll(listeCI);
		}
		
		// Appeler la vue en lui fournissant la liste de geeks filt�e
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Resultat");
		mav.addObject("geeks", liste);
		return mav;
	}
	
}
