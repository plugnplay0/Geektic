package geektic.service;

import geektic.dao.InteretDAO;
import geektic.model.Geek;
import geektic.model.Interet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class InteretService {

	@Autowired
	InteretDAO interetDAO;
	
	public Interet trouverParId(long id) {
		Interet interet = interetDAO.findById(id);
		return interet;
	}
	
	public List<Geek> trouverGeeksParInterets(long interet1, long interet2, long interet3) {
		List<Geek> listeCI = new ArrayList<Geek>();
		if(interet1 != 0) {
			listeCI = (trouverParId(interet1)).getGeeks();
		}
		if(interet2 != 0) {
			listeCI.addAll((trouverParId(interet2)).getGeeks());
		}
		if(interet2 != 0) {
			listeCI.addAll((trouverParId(interet3)).getGeeks());
		}
		return listeCI;
	}
	
}
