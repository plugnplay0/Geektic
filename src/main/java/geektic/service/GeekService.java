package geektic.service;

import geektic.dao.GeekDAO;
import geektic.model.Geek;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GeekService {

	@Autowired
	GeekDAO geekDAO;
	
	public List<Geek> listerTous() {
		List<Geek> liste = geekDAO.findAll();
		return liste;
	}
	
	public Geek trouverParId(long id) {
		Geek geek = geekDAO.findById(id);
		return geek;
	}
	
	public List<Geek> trouverSelonCriteres(
			String pseudo,
			String nom,
			String prenom,
			String sexe,
			int agemin,
			int agemax,
			long interet1,
			long interet2,
			long interet3)
	{
		// Pseudo, nom prénom et sexe
		List<Geek> total = geekDAO.findByCriteria(pseudo, nom, prenom, sexe);
		
		// Ages min et max
		if((agemin != 0) && (agemax == 0)) {
			total.addAll(geekDAO.findByAgeMin(agemin));
		} else if((agemin == 0) && (agemax != 0)) {
			total.addAll(geekDAO.findByAgeMax(agemax));
		} else if((agemin != 0) && (agemax != 0)) {
			total.addAll(geekDAO.findByAgeBetween(agemin, agemax));
		}
		
		//Centres d'intérêt
		
		
		return total;
	}
}
