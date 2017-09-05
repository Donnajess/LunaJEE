package com.formation.entite;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.controle.utilitaires.GestionDates;


@Entity
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long code;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	private Categorie categorie;
	
	@Basic
	private String designation;

	@Basic
	private int quantite;

	@Column(name="prix_unitaire")
	private double prixUnitaire;

	private LocalDate date;

	
	public Article(Categorie categorie,String designation,int quantite, double prixUnitaire,Instant date) {
		this.categorie = categorie;
		this.designation = designation;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		setDate(date);
	}

	/*
	 * Constructeur 2
	 */
	public Article() {
	}

	/*
	 * Accesseurs
	 */
	public Long getCode() {
		return code;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public String getDesignation() {
		return designation;
	}

	public int getQuantite() {
		return quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public Instant getDate() {
		return GestionDates.instant(date);
	}
	
	public void setCode(Long code) {
		this.code = code;
	}

	public void setReference(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setPrixUnitaire(double prix_unitaire) {
		this.prixUnitaire = prix_unitaire;
	}
	
	public void setDate(Instant date) {
		this.date = GestionDates.date(date);
	}
}