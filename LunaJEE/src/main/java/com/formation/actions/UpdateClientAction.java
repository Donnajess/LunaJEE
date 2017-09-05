package com.formation.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.entite.Adresse;
import com.formation.entite.Client;
import com.formation.services.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Action("/updateClient")
@Results({ @Result(name = "success", location = "/modifClient.jsp"),
		@Result(name = "exec", type = "redirectAction", location = "listClient.action"), })
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
		return null;
	}

	@Override
	public String execute() throws Exception {
		Long c = Long.parseLong(code);
		setClient(clientService.getClientById(c));
		return SUCCESS;
	}

	@Action("majClient")
	public String update() {
		Long c = Long.parseLong(code);
		getClient().setCode(c);
		getClient().setNom(client.getNom());
		getClient().setPrenom(client.getPrenom());
		getClient().setAdresse(adresse);
		clientService.updateClient(getClient());
		return "exec";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
