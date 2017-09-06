package com.formation.entite;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name = "LignesCommandes")
public class Ligne implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = { CascadeType.ALL }, optional = false)
	private Article article;

	@ManyToOne(cascade = { CascadeType.ALL }, optional = false)
	private Commande commande;

	private int quantite;

	@Transient
	private double prix;

	@Transient
	private int identifiant;

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public Ligne(Article unArticle, int quantite) {
		this();
		this.article = unArticle;
		this.quantite = quantite;
	}

	public Ligne() {
		super();
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article unArticle) {
		this.article = unArticle;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return article.getPrixUnitaire();
	}

	public double getTotal() {
		return quantite * getPrixUnitaire();
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}