package com.formation.entite;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.formation.controle.utilitaires.ConvertisseurLocalDateTime;
import com.formation.controle.utilitaires.GestionDates;


@Entity
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long code;

	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;

	private String modeReglement;

	@Convert(converter=ConvertisseurLocalDateTime.class)
	private LocalDateTime date;

	@OneToMany(	cascade = { CascadeType.ALL },
				mappedBy = "commande")
	private List<Ligne> lignes = new ArrayList<>();

	private double prixTTC;
	/*
	 * Constructeur 1
	 */
	public Commande(Long code) {
		this.code = code;
	}

	/*
	 * Constructeur 2
	 */
	public Commande() {
		super();
	}
	
	public Commande(Client client, String modeReglement, LocalDateTime date, List<Ligne> lignes) {
		super();
		this.client = client;
		this.setModeReglement(modeReglement);
		this.date = date;
		this.lignes = lignes;
	}

	/*
	 * Accesseurs
	 */
	public Long getCode() {
		return code;
	}

	public Client getClient() {
		return client;
	}

	public double getTotalTTC() {
//		double total = 0;
//		for (Ligne ligne : lignes) {
//			total += ligne.getTotal();
//		}
//		return total;
		return lignes
				.stream()
				.mapToDouble(Ligne::getTotal)
				.sum();
	}


	public Instant getInstant() {
		return GestionDates.instant(date);
	}

	public void setClient(Client client) {
		this.client = client;
	}


	void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public LocalDateTime maintenant() {
		setDate(GestionDates.maintenant());
		return date;
	}

	public List<Ligne> getLignes() {
		return lignes;
	}
	

	public void ajouter(Ligne uneLigne) {
		uneLigne.setCommande(this);
		lignes.add(uneLigne);
	}

	// ------------------------------------
	// Méthodes utilisées par Jasper
	// ------------------------------------
	@Deprecated
	public Date getDate() {
		return Date.from(getInstant());
	}
	// ------------------------------------

	public double getPrixTTC() {
		return prixTTC;
	}

	public void setPrixTTC(double prixTTC) {
		this.prixTTC = prixTTC;
	}

	public String getModeReglement() {
		return modeReglement;
	}

	public void setModeReglement(String modeReglement) {
		this.modeReglement = modeReglement;
	}
}