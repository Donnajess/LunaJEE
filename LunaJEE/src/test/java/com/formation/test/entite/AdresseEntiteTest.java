package com.formation.test.entite;

import org.junit.Assert;
import org.junit.Test;

import com.formation.entite.Adresse;

public class AdresseEntiteTest {

	
	@Test
	public void testGetRue() {
		Adresse adresse = new Adresse("rue","code","ville");
		String rue = adresse.getRue();
		Assert.assertEquals("rue", rue);
	}
	@Test
	public void testGetCode() {
		Adresse adresse = new Adresse("rue","code","ville");
		String code = adresse.getCodePostal();
		Assert.assertEquals("code", code);
	}
	@Test
	public void testGetVille() {
		Adresse adresse = new Adresse("rue","code","ville");
		String ville = adresse.getVille();
		Assert.assertEquals("ville", ville);
	}
	@Test
	public void testSetRue() {
		Adresse adresse = new Adresse("rue","code","ville");
		adresse.setRue("26 rue");
		String rue = adresse.getRue();
		Assert.assertEquals("26 rue", rue);
	}
	@Test
	public void testSetCode() {
		Adresse adresse = new Adresse("rue","code","ville");
		adresse.setCodePostal("62500");
		String code = adresse.getCodePostal();
		Assert.assertEquals("62500", code);
	}
	@Test
	public void testSetVille() {
		Adresse adresse = new Adresse("rue","code","ville");
		adresse.setVille("Lille");
		String ville = adresse.getVille();
		Assert.assertEquals("Lille", ville);
	}
	
}
