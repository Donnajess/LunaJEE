package com.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.DAO.ClientDAO;
import com.formation.entite.Client;
import com.formation.services.ClientService;

@Service("clientService")
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientDAO clientDAO; 
	
	@Override
	public List<Client> getAllClient() {
		return clientDAO.getAllClient();
	}

	@Override
	public Client getClientById(long code) {
		return clientDAO.getClientById(code);
	}

	@Override
	public void addClient(Client client) {
		clientDAO.addClient(client);
	}

	@Override
	public void updateClient(Client client) {
		clientDAO.updateClient(client);
	}

	@Override
	public void deleteClient(long code) {
		clientDAO.deleteClient(code);
	}

}
