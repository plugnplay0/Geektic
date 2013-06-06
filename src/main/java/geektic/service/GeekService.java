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
	
	public Geek trouverParPseudo(String pseudo) {
		Geek geek = geekDAO.findByPseudo(pseudo);
		return geek;
	}
	
	public List<Geek> trouverParSexe(char sexe) {
		List<Geek> liste = geekDAO.findBySexe(sexe);
		return liste;
	}
	
}
