package com.formation.test.entite;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.formation.entite.Adresse;
import com.formation.entite.Article;
import com.formation.entite.Categorie;
import com.formation.entite.Client;
import com.formation.entite.Commande;
import com.formation.entite.Ligne;

public class CommandeEntiteTest {

	@Test
	public void testGetClient() {
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Adresse adresse = new Adresse("rue","code","ville");
		Client client = new Client("nom", "prenom", true, instant, adresse);
		Categorie categorie = new Categorie("des");
		Article article = new Article(categorie, "design", 10, 10, instant);
		List<Ligne> listLignes = new ArrayList<Ligne>(); 
		Commande commande = new Commande(client,"CB", datetime, listLignes);
		Ligne ligne = new Ligne(article, 15);
		commande.ajouter(ligne);
		Assert.assertEquals(client, commande.getClient());
	}
	@Test
	public void testGetModeReglement() {
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Adresse adresse = new Adresse("rue","code","ville");
		Client client = new Client("nom", "prenom", true, instant, adresse);
		Categorie categorie = new Categorie("des");
		Article article = new Article(categorie, "design", 10, 10, instant);
		List<Ligne> listLignes = new ArrayList<Ligne>(); 
		Commande commande = new Commande(client,"CB", datetime, listLignes);
		Ligne ligne = new Ligne(article, 15);
		commande.ajouter(ligne);
		Assert.assertEquals("CB", commande.getModeReglement());
	}
	@Test
	public void testGetLignes() {
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Adresse adresse = new Adresse("rue","code","ville");
		Client client = new Client("nom", "prenom", true, instant, adresse);
		Categorie categorie = new Categorie("des");
		Article article = new Article(categorie, "design", 10, 10, instant);
		List<Ligne> listLignes = new ArrayList<Ligne>(); 
		Commande commande = new Commande(client,"CB", datetime, listLignes);
		Ligne ligne = new Ligne(article, 15);
		commande.ajouter(ligne);
		Assert.assertEquals(listLignes, commande.getLignes());
	}
	@Test
	public void testSetClient() {
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Adresse adresse = new Adresse("rue","code","ville");
		Client client = new Client("nom", "prenom", true, instant, adresse);
		Client client2 = new Client("nom2", "prenom2", false, instant, adresse);
		Categorie categorie = new Categorie("des");
		Article article = new Article(categorie, "design", 10, 10, instant);
		List<Ligne> listLignes = new ArrayList<Ligne>(); 
		Commande commande = new Commande(client,"CB", datetime, listLignes);
		Ligne ligne = new Ligne(article, 15);
		commande.ajouter(ligne);
		commande.setClient(client2);
		Assert.assertEquals(client2, commande.getClient());
	}
	@Test
	public void testSetModeReglement() {
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Adresse adresse = new Adresse("rue","code","ville");
		Client client = new Client("nom", "prenom", true, instant, adresse);
		Categorie categorie = new Categorie("des");
		Article article = new Article(categorie, "design", 10, 10, instant);
		List<Ligne> listLignes = new ArrayList<Ligne>(); 
		Commande commande = new Commande(client,"CB", datetime, listLignes);
		Ligne ligne = new Ligne(article, 15);
		commande.ajouter(ligne);
		commande.setModeReglement("chèque");
		Assert.assertEquals("chèque", commande.getModeReglement());
	}
	@Test
	public void testSetLignes() {
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Adresse adresse = new Adresse("rue","code","ville");
		Client client = new Client("nom", "prenom", true, instant, adresse);
		Categorie categorie = new Categorie("des");
		Article article = new Article(categorie, "design", 10, 10, instant);
		List<Ligne> listLignes = new ArrayList<Ligne>(); 
		Commande commande = new Commande(client,"CB", datetime, listLignes);
		Ligne ligne2 = new Ligne(article, 50);
		commande.ajouter(ligne2);
		Assert.assertEquals(listLignes, commande.getLignes());
	}
	
}
