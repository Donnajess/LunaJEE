package com.formation.actions;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.DAO.AdresseDAO;
import com.formation.DAO.ClientDAO;
import com.formation.entite.Adresse;
import com.formation.entite.Client;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ListClientAction extends ActionSupport implements ModelDriven<Client> {
	private static final long serialVersionUID = 1L;

	private Client client = new Client();
	private List<Client> clientList;
	@Autowired
	private ClientDAO clientDAO;
	private String code;
	
	@Override
	public Client getModel() {
		return client;
	}
	
	public String delete()
	{
		Long c = Long.parseLong(code);
		clientDAO.deleteClient(c);
		return SUCCESS;
	}
	
	public String add()
	{
		Adresse adr = new Adresse("ff","03120","Lapalisse");
		client.setAdresse(adr);
		Instant in = Instant.now();
		client.setDateCreation(in);
		clientDAO.addClient(client);
		return SUCCESS;
	}
	
	public String listClient()
	{
		clientList = clientDAO.getAllClient();
		return SUCCESS;
	}
		
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}
}
