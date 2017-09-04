package com.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.DAO.LigneDAO;
import com.formation.entite.Ligne;
import com.formation.services.LigneService;

@Service("ligneService")
public class LigneServiceImpl implements LigneService {

	@Autowired
	private LigneDAO ligneDAO;
	
	@Override
	public List<Ligne> getAllLigne() {
		return ligneDAO.getAllLigne();
	}

	@Override
	public Ligne getLigneById(long id) {
		return ligneDAO.getLigneById(id);
	}

	@Override
	public void addLigne(Ligne ligne) {
		ligneDAO.addLigne(ligne);
	}

	@Override
	public void updateLigne(Ligne ligne) {
		ligneDAO.updateLigne(ligne);
	}

	@Override
	public void deleteLigne(long id) {
		ligneDAO.deleteLigne(id);
	}

}
