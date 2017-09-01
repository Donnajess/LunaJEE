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

	/* sessionFactory est injecté avec @Autowired, on ajoute son Setter */
	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Client").list();
	}

	@Override
	public Client getClientById(long code) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().get(Client.class, code);
	}

	@Override
	public void addClient(Client client) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(client);
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(client);
	}

	@Override
	public void deleteClient(long code) {
		// TODO Auto-generated method stub
		Client client = sessionFactory.getCurrentSession().get(Client.class, code);
		this.sessionFactory.getCurrentSession().delete(client);
	}

}
