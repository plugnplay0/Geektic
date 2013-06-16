package geektic.service;

import geektic.dao.GeekDAO;
import geektic.model.Geek;

import java.util.ArrayList;
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
	
	public Geek trouverParPseudo(String pseudo) {
		Geek geek = geekDAO.findByPseudo(pseudo);
		return geek;
	}
	
	public List<Geek> trouverParSexe(String sexe) {
		List<Geek> liste = geekDAO.findBySexe(sexe);
		return liste;
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
		List<Geek> total = geekDAO.findByCriteria(pseudo, nom, prenom, sexe, agemin, agemax, interet1, interet2, interet3);
		//total.addAll(geekDAO.findByNom(nom));
		//total.addAll(geekDAO.findByPrenom(prenom));
		return total;
	}
}
