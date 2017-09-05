package com.formation.services;

import java.util.List;

import com.formation.entite.Categorie;

public interface CategorieService {
	
	public List<Categorie> getAllCategories();

	public Categorie getCategorieById(long code);

	public void addCategorie(Categorie categorie);

	public void updateCategorie(Categorie categorie);

	public void deleteCategorie(long code);
}
