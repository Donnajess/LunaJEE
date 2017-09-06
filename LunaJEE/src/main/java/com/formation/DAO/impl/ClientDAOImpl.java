package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.ClientDAO;
import com.formation.entite.Client;
import com.formation.entite.Commande;

@Repository("clientDAO")
@Transactional
public class ClientDAOImpl implements ClientDAO {

	@Autowired  
	private SessionFactory sessionFactory;
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getAllClient() {
		return this.sessionFactory.getCurrentSession().createQuery("from Client").list();
	}

	@Override
	public Client getClientById(long code) {
		return this.sessionFactory.getCurrentSession().get(Client.class, code);
	}

	@Override
	public void addClient(Client client) {
		this.sessionFactory.getCurrentSession().save(client);
	}

	@Override
	public void updateClient(Client client) {
		this.sessionFactory.getCurrentSession().update(client);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteClient(long code) {
		List<Commande> commandes = this.sessionFactory.getCurrentSession().createQuery("from Commande").list();
		Client client = sessionFactory.getCurrentSession().get(Client.class, code);
		for(Commande c : commandes){
			if(c.getClient().getCode() == client.getCode()){
				this.sessionFactory.getCurrentSession().delete(c);
			}
		}
		this.sessionFactory.getCurrentSession().delete(client);
	}
}
