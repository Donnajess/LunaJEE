package com.formation.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.DAO.ClientDAO;
import com.formation.entite.Adresse;
import com.formation.entite.Client;
import com.formation.services.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateClientAction extends ActionSupport implements ModelDriven<Client> {

	private static final long serialVersionUID = 1L;

	private Client client;
	private Adresse adresse;

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	private static String code;

	public String getCode() {
		return code;
	}

	public void setCode(String c) {
		code = c;
	}

	@Autowired
	private ClientService clientService;

	@Override
	public Client getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String majChamp() {
		Long c = Long.parseLong(code);
		setClient(clientService.getClientById(c));
		return SUCCESS;
	}

	public String update() {
		Long c = Long.parseLong(code);
		getClient().setCode(c);
		getClient().setNom(client.getNom());
		getClient().setPrenom(client.getPrenom());
		getClient().setAdresse(adresse);
		clientService.updateClient(getClient());
		return SUCCESS;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
