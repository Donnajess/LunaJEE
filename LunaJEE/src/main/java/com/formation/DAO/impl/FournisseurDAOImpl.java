package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.FournisseurDAO;
import com.formation.entite.Fournisseur;

@Repository("fournisseurDAO")
@Transactional
public class FournisseurDAOImpl implements FournisseurDAO {

	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Fournisseur> getAllFournisseur() {
		return this.sessionFactory.getCurrentSession().createQuery("from Fournisseur").list();
	}

	@Override
	public Fournisseur getFournisseurById(long id) {
		return this.sessionFactory.getCurrentSession().get(Fournisseur.class, id);
	}

	@Override
	public void addFournisseur(Fournisseur fournisseur) {
		this.sessionFactory.getCurrentSession().save(fournisseur);
	}

	@Override
	public void updateFournisseur(Fournisseur fournisseur) {
		this.sessionFactory.getCurrentSession().save(fournisseur);
	}

	@Override
	public void deleteFournisseur(long id) {
		Fournisseur fournisseur = sessionFactory.getCurrentSession().get(Fournisseur.class, id);
		this.sessionFactory.getCurrentSession().delete(fournisseur);
	}

}
