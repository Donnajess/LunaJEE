package com.formation.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.entite.Commande;
import com.formation.services.CommandeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Action("/afficherCommande")
@Results({ @Result(name = "success", location = "/listCommande.jsp"),
	@Result(name = "exec", type = "redirectAction", location = "afficherCommande.action"),})
public class AffichageCommandeAction extends ActionSupport implements ModelDriven<Commande> {

	private static final long serialVersionUID = 1L;

	private List<Commande> commandeList;
	private Commande commande;
	private String code;
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Autowired 
	private CommandeService commandeService;
	
	public CommandeService getCommandeService() {
		return commandeService;
	}

	public void setCommandeService(CommandeService commandeService) {
		this.commandeService = commandeService;
	}

	@Override
	public String execute() throws Exception {
		commandeList = commandeService.getAllCommande();
		return SUCCESS;
	}
	
	@Action("deleteCommande")
	public String delete(){
		commandeService.deleteCommande(Long.parseLong(code));
		return "exec";
	}

	@Override
	public Commande getModel() {
		return commande;
	}

	public List<Commande> getCommandeList() {
		return commandeList;
	}

	public void setCommandeList(List<Commande> commandeList) {
		this.commandeList = commandeList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
