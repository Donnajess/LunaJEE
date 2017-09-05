package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.CommandeDAO;
import com.formation.entite.Commande;

@Repository("commandeDAO")
@Transactional
public class CommandeDAOImpl implements CommandeDAO {

	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Commande> getAllCommande() {
		return this.sessionFactory.getCurrentSession().createQuery("from Commande").list();
	}

	@Override
	public Commande getCommandeById(long code) {
		return this.sessionFactory.getCurrentSession().get(Commande.class, code);
	}

	@Override
	public void addCommande(Commande commande) {
		this.sessionFactory.getCurrentSession().save(commande);
	}

	@Override
	public void updateCommande(Commande commande) {
		this.sessionFactory.getCurrentSession().save(commande);
	}

	@Override
	public void deleteCommande(long code) {
		Commande commande = sessionFactory.getCurrentSession().get(Commande.class, code);
		this.sessionFactory.getCurrentSession().delete(commande);
	}

}
