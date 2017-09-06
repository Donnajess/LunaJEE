package com.formation.test.entite;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

import com.formation.entite.Article;
import com.formation.entite.Categorie;

public class ArtileEntiteTest {

	@Test
	public void testGetDesignation() {
		Categorie categorie = new Categorie("test");
		Article article = new Article(categorie, "design", 10, 10, Instant.now());
		Assert.assertEquals("design", article.getDesignation());
	}
	@Test
	public void testGetQuantite() {
		Categorie categorie = new Categorie("test");
		Article article = new Article(categorie, "design", 10, 10, Instant.now());
		Assert.assertEquals(10, article.getQuantite());
	}
	@Test
	public void testGetPrixUnitaire() {
		Categorie categorie = new Categorie("test");
		Article article = new Article(categorie, "design", 10, 10, Instant.now());
		Assert.assertEquals(10, article.getPrixUnitaire(), 10);
	}
	@Test
	public void testGetCategorie() {
		Categorie categorie = new Categorie("test");
		Article article = new Article(categorie, "design", 10, 10, Instant.now());
		Assert.assertEquals(categorie, article.getCategorie());
	}
	@Test
	public void testSetDesignation() {
		Categorie categorie = new Categorie("test");
		Article article = new Article(categorie, "design", 10, 10, Instant.now());
		article.setDesignation("des");
		Assert.assertEquals("des", article.getDesignation());
	}
	@Test
	public void testSetQuantite() {
		Categorie categorie = new Categorie("test");
		Article article = new Article(categorie, "design", 10, 10, Instant.now());
		article.setQuantite(12);
		Assert.assertEquals(12, article.getQuantite());
	}
	@Test
	public void testSetPrixUnitaire() {
		Categorie categorie = new Categorie("test");
		Article article = new Article(categorie, "design", 10, 10, Instant.now());
		article.setPrixUnitaire(15);
		Assert.assertEquals(15, article.getPrixUnitaire(), 15);
	}
	@Test
	public void testSetReference() {
		Categorie categorie = new Categorie("test");
		Categorie cat2 = new Categorie("test2");
		Article article = new Article(categorie, "design", 10, 10, Instant.now());
		article.setReference(cat2);
		Assert.assertEquals(cat2, article.getCategorie());
	}
	
}
