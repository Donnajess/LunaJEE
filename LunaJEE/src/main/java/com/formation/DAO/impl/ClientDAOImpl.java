package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.ClientDAO;
import com.formation.entite.Client;

@Repository("clientDAO")
@Transactional
public class ClientDAOImpl implements ClientDAO {

	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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

	@Override
	public void deleteClient(long code) {
		Client client = sessionFactory.getCurrentSession().get(Client.class, code);
		this.sessionFactory.getCurrentSession().delete(client);
	}

}
