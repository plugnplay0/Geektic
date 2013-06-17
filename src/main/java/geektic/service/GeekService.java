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
	
	public List<Geek> trouverSelonCriteres(
			String pseudo,
			String nom,
			String prenom,
			String sexe,
			int agemin,
			int agemax)
	{
		// Pseudo, nom prénom et sexe
		List<Geek> liste = geekDAO.findByCriteria(pseudo, nom, prenom, sexe);
		
		// Ages min et max
		List<Geek> aRetirer = new ArrayList<Geek>();
		if(agemin != 0) {
			for(Geek geek : liste) {
				if(geek.getAge() < agemin) {
					aRetirer.add(geek);
				}
			}
		}
		if(agemax != 0) {
			for(Geek geek : liste) {
				if(geek.getAge() > agemax) {
					aRetirer.add(geek);
				}
			}
		}
		liste.removeAll(aRetirer);
		
		// Supprimer le geek 'flag' s'il y est
		Geek flag = trouverParId(0);
		if(liste.contains(flag)) {
			liste.remove(flag);
		}
		
		return liste;
	}
}
