package com.formation.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.DAO.LigneDAO;
import com.formation.entite.Ligne;

public class LigneDAOImpl implements LigneDAO {

	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Ligne> getAllLigne() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Ligne").list();
	}

	@Override
	public Ligne getLigneById(long id) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().get(Ligne.class, id);
	}

	@Override
	public void addLigne(Ligne ligne) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(ligne);
	}

	@Override
	public void updateLigne(Ligne ligne) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(ligne);
	}

	@Override
	public void deleteLigne(long id) {
		// TODO Auto-generated method stub
		Ligne ligne = sessionFactory.getCurrentSession().get(Ligne.class, id);
		this.sessionFactory.getCurrentSession().delete(ligne);
	}

}
