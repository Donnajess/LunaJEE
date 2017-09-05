package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.CategorieDAO;
import com.formation.entite.Categorie;

@Repository("categorieDAO")
@Transactional
public class CategorieDAOImpl implements CategorieDAO {

	@Autowired  
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCategorie() {
		return this.sessionFactory.getCurrentSession().createQuery("from Categorie").list();
	}

	@Override
	public Categorie getCategorieById(long code) {
		return this.sessionFactory.getCurrentSession().get(Categorie.class, code);
	}

	@Override
	public void addCategorie(Categorie categorie) {
		this.sessionFactory.getCurrentSession().save(categorie);
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(categorie);
	}

	@Override
	public void deleteCategorie(long code) {
		Categorie categorie = sessionFactory.getCurrentSession().get(Categorie.class, code);
		this.sessionFactory.getCurrentSession().delete(categorie);
	}

}
