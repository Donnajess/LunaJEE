package com.formation.DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import com.formation.entite.Categorie;

public interface CategorieDAO {

	public List<Categorie> getAllCategorie();

	public Categorie getCategorieById(long code);

	public void addCategorie(Categorie categorie);

	public void updateCategorie(Categorie categorie);

	public void deleteCategorie(long code);
	public void setSessionFactory(SessionFactory sessionFactory);
	public SessionFactory getSessionFactory();
}
