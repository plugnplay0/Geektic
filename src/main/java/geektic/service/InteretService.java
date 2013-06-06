package geektic.service;

import geektic.dao.InteretDAO;
import geektic.model.Interet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class InteretService {

	@Autowired
	InteretDAO interetDAO;
	
	public List<Interet> listerTous() {
		List<Interet> liste = interetDAO.findAll();
		return liste;
	}
	
	public Interet trouverParId(long id) {
		Interet interet = interetDAO.findById(id);
		return interet;
	}
	
}
