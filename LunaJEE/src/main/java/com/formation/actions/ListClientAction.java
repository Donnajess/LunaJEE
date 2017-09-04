package com.formation.actions;



import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.entite.Adresse;
import com.formation.entite.Client;
import com.formation.services.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ListClientAction extends ActionSupport implements ModelDriven<Client> {
	private static final long serialVersionUID = 1L;

	private Client client;
	private Adresse adresse;
	private List<Client> clientList;
	@Autowired
	private ClientService clientService;
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public Client getModel() {
		return client;
	}
	
	public String delete()
	{
		Long c = Long.parseLong(getCode());
		clientService.deleteClient(c);
		return SUCCESS;
	}
	
	public String add()
	{
		client.setAdresse(adresse);
		Instant in = Instant.now();
		client.setDateCreation(in);
		clientService.addClient(client);
		return SUCCESS;
	}
	
	public String listClient()
	{
		clientList = clientService.getAllClient();
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
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
