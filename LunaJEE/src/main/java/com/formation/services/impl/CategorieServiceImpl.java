package com.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.DAO.CategorieDAO;
import com.formation.entite.Categorie;
import com.formation.services.CategorieService;


@Service("categorieService")
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieDAO categorieDAO;
	
	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return categorieDAO.getAllCategorie();
	}

	@Override
	public Categorie getCategorieById(long code) {
		// TODO Auto-generated method stub
		return categorieDAO.getCategorieById(code);
	}

	@Override
	public void addCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		categorieDAO.addCategorie(categorie);
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		categorieDAO.updateCategorie(categorie);
	}

	@Override
	public void deleteCategorie(long code) {
		// TODO Auto-generated method stub
		categorieDAO.deleteCategorie(code);
	}

}
