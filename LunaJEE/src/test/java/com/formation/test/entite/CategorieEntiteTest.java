package com.formation.test.entite;


import org.junit.Assert;
import org.junit.Test;

import com.formation.entite.Categorie;

public class CategorieEntiteTest {

	@Test
	public void testGetDesignation() {
		Categorie categorie = new Categorie("test");
		Assert.assertEquals("test", categorie.getDesignation());
	}
	@Test
	public void testSetDesignation() {
		Categorie categorie = new Categorie("test");
		categorie.setDesignation("des");
		Assert.assertEquals("des", categorie.getDesignation());
	}

	
}
