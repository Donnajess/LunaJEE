package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.AdresseDAO;
import com.formation.entite.Adresse;

@Repository("adresseDAO")
@Transactional
public class AdresseDAOImpl implements AdresseDAO {

	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Adresse> getAllAdresse() {
		return this.sessionFactory.getCurrentSession().createQuery("from Adresse").list();
	}

	@Override
	public Adresse getAdresseById(long id) {
		return this.sessionFactory.getCurrentSession().get(Adresse.class, id);
	}

	@Override
	public void addAdresse(Adresse adresse) {
		this.sessionFactory.getCurrentSession().save(adresse);
	}

	@Override
	public void updateAdresse(Adresse adresse) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(adresse);
	}

	@Override
	public void deleteAdresse(long id) {
		Adresse adresse = sessionFactory.getCurrentSession().get(Adresse.class, id);
		this.sessionFactory.getCurrentSession().delete(adresse);
	}

}
