package com.formation.test.entite;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

import com.formation.entite.Adresse;
import com.formation.entite.Client;


public class ClientEntiteTest {

	@Test
	public void testGetNom() {
		Adresse adresse = new Adresse("rue", "code", "ville");
		Instant date = Instant.now();
		Client client = new Client("nom","prenom",true,date,adresse);
		Assert.assertEquals("nom", client.getNom());
	}
	@Test
	public void testGetPrenom() {
		Adresse adresse = new Adresse("rue", "code", "ville");
		Instant date = Instant.now();
		Client client = new Client("nom","prenom",true,date,adresse);
		Assert.assertEquals("prenom", client.getPrenom());
	}
	@Test
	public void testGetCarte_fidelite() {
		Adresse adresse = new Adresse("rue", "code", "ville");
		Instant date = Instant.now();
		Client client = new Client("nom","prenom",true,date,adresse);
		Assert.assertEquals(true, client.isCarte_fidele());
	}
	@Test
	public void testGetAdresse() {
		Adresse adresse = new Adresse("rue", "code", "ville");
		Instant date = Instant.now();
		Client client = new Client("nom","prenom",true,date,adresse);
		Assert.assertEquals(adresse, client.getAdresse());
	}
	@Test
	public void testSetNom() {
		Adresse adresse = new Adresse("rue", "code", "ville");
		Instant date = Instant.now();
		Client client = new Client("nom","prenom",true,date,adresse);
		client.setNom("nom2");
		Assert.assertEquals("nom2", client.getNom());
	}
	@Test
	public void testSetPrenom() {
		Adresse adresse = new Adresse("rue", "code", "ville");
		Instant date = Instant.now();
		Client client = new Client("nom","prenom",true,date,adresse);
		client.setPrenom("prenom2");
		Assert.assertEquals("prenom2", client.getPrenom());
	}
	@Test
	public void testSetCarte_fidelite() {
		Adresse adresse = new Adresse("rue", "code", "ville");
		Instant date = Instant.now();
		Client client = new Client("nom","prenom",true,date,adresse);
		client.setCarte_fidele(false);
		Assert.assertEquals(false, client.isCarte_fidele());
	}
	@Test
	public void testSetAdresse() {
		Adresse adresse = new Adresse("rue", "code", "ville");
		Adresse adresse2 = new Adresse("rue2", "code2", "ville2");
		Instant date = Instant.now();
		Client client = new Client("nom","prenom",true,date,adresse);
		client.setAdresse(adresse2);
		Assert.assertEquals(adresse2, client.getAdresse());
	}
}
