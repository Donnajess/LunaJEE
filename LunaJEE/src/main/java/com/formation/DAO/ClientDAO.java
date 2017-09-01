package com.formation.DAO;

import java.util.List;

import com.formation.entite.Client;



public interface ClientDAO {
	
	public List<Client> getAllClient();
	public Client getClientById(long code);
	public void addClient(Client client);
	public void updateClient(Client client);
	public void deleteClient(long code);
}
