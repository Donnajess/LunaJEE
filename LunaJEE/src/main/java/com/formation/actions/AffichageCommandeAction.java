package com.formation.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.entite.Commande;
import com.formation.services.CommandeService;
import com.opensymphony.xwork2.ActionSupport;

@Action("/afficherCommande")
@Results({ @Result(name = "success", location = "/listCommande.jsp"), })
public class AffichageCommandeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Commande> commandeList;
	
	@Autowired 
	private CommandeService commandeService;
	
	@Override
	public String execute() throws Exception {
		commandeList = commandeService.getAllCommande();
		return SUCCESS;
	}

	public List<Commande> getMesCommandes() {
		return commandeList;
	}

	public void setMesCommandes(List<Commande> mesCommandes) {
		this.commandeList = mesCommandes;
	}
	
}
