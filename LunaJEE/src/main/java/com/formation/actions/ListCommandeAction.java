package com.formation.actions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.entite.Article;
import com.formation.entite.Client;
import com.formation.entite.Commande;
import com.formation.entite.Ligne;
import com.formation.services.ArticleService;
import com.formation.services.ClientService;
import com.formation.services.CommandeService;
import com.opensymphony.xwork2.ActionSupport;

@Action("/listCommande")
@Results({ @Result(name = "success", location = "/accueilCommande.jsp"),
		@Result(name = "exec", type = "redirectAction", location = "listCommande.action"),
		@Result(name = "valider", type = "redirectAction", location = "afficherCommande.action"), })
public class ListCommandeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ArticleService articleService;

	private String identifiant;
	private static List<Ligne> commandeList = new ArrayList<Ligne>();
	private Ligne ligne;
	private List<Article> listArticle;
	private List<Client> listClient;
	private String article;
	private static String client;
	private static String modeReglement;
	private List<String> listReglements;

	private static double montant = 0.00;

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String cli) {
		client = cli;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	private String quantite;

	@Override
	public String execute() throws Exception {
		listArticle = articleService.getAllArticles();
		listClient = clientService.getAllClient();
		listReglements = new ArrayList<String>();
		listReglements.add("Cheques");
		listReglements.add("Carte Bleue");
		listReglements.add("PayPal");
		return SUCCESS;
	}

	@Action("addLigne")
	public String add() {
		Article monArticle = null;
		monArticle = articleService.getArticleById(Long.parseLong(article));
		int q = Integer.parseInt(quantite);
		double prix = monArticle.getPrixUnitaire() * q;
		Ligne l = new Ligne(monArticle, q);
		l.setPrix(prix);
		l.setIdentifiant(commandeList.size());
		commandeList.add(l);
		montant = 0.00;
		for (Ligne ligne : commandeList) {
			montant += ligne.getPrix();
		}
		return "exec";
	}

	@Action("deleteLigne")
	public String delete() {
		int id = Integer.parseInt(identifiant);
		Ligne maLigne = null;
		for (Ligne l : commandeList) {
			if (l.getIdentifiant() == id) {
				maLigne = l;
			}
		}
		commandeList.remove(maLigne);
		montant = 0.00;
		for (Ligne ligne : commandeList) {
			montant += ligne.getPrix();
		}
		return "exec";
	}

	@Action("validerCommande")
	public String valide() {
		Client monClient = null;
		monClient = clientService.getClientById(Long.parseLong(client));
		Commande c = new Commande(monClient, "Cheques", LocalDateTime.now(), new ArrayList<Ligne>());
		for (Ligne l : commandeList) {
			c.ajouter(l);
		}
		c.setPrixTTC(montant);
		commandeService.addCommande(c);
		montant = 0.00;
		commandeList.clear();
		client = null;
		return "valider";
	}

	public List<Article> getListArticle() {
		return listArticle;
	}

	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public Ligne getLigne() {
		return ligne;
	}

	public void setLigne(Ligne ligne) {
		this.ligne = ligne;
	}

	public List<Ligne> getCommandeList() {
		return commandeList;
	}

	public void setCommandeList(List<Ligne> commandeList1) {
		commandeList = commandeList1;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant1) {
		montant = montant1;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public List<String> getListReglements() {
		return listReglements;
	}

	public void setListReglements(List<String> listReglements) {
		this.listReglements = listReglements;
	}

	public String getModeReglement() {
		return modeReglement;
	}

	public void setModeReglement(String modeReglement) {
		this.modeReglement = modeReglement;
	}


}
