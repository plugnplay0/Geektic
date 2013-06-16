package geektic.service;

import geektic.dao.TypeDAO;
import geektic.model.Type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeService {

	@Autowired
	TypeDAO typeDAO;
	
	public List<Type> listerTous() {
		List<Type> liste = typeDAO.findAll();
		return liste;
	}
	
}
