package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.LigneDAO;
import com.formation.entite.Ligne;


@Repository("ligneDAO")
@Transactional
public class LigneDAOImpl implements LigneDAO {

	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Ligne> getAllLigne() {
		return this.sessionFactory.getCurrentSession().createQuery("from Ligne").list();
	}

	@Override
	public Ligne getLigneById(long id) {
		return this.sessionFactory.getCurrentSession().get(Ligne.class, id);
	}

	@Override
	public void addLigne(Ligne ligne) {
		this.sessionFactory.getCurrentSession().save(ligne);
	}

	@Override
	public void updateLigne(Ligne ligne) {
		this.sessionFactory.getCurrentSession().save(ligne);
	}

	@Override
	public void deleteLigne(long id) {
		Ligne ligne = sessionFactory.getCurrentSession().get(Ligne.class, id);
		this.sessionFactory.getCurrentSession().delete(ligne);
	}

}
