package com.formation.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.CategorieDAO;
import com.formation.entite.Categorie;
import com.formation.services.CategorieService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategorieServiceTest {

	private static ApplicationContext context;
	private static CategorieService categorieService;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		categorieService = (CategorieService) context.getBean("categorieService");
	}
	
	@Test
	public void test1AddCategorie() {
		Categorie cat = new Categorie("Electromenager");
		categorieService.addCategorie(cat);
		Assert.assertEquals(1, categorieService.getAllCategories().size());
	}

	@Test
	public void test2UpdateCategorie() {
		Categorie cat = categorieService.getCategorieById(1);
		cat.setDesignation("Jouet");
		categorieService.updateCategorie(cat);
		Assert.assertEquals(cat.getDesignation(), categorieService.getCategorieById(1).getDesignation());
	}

	@Test
	public void test3RetrieveCategorie() {
		Categorie cat = categorieService.getCategorieById(1);
		Assert.assertNotNull(cat);
	}

	@Test
	public void test4RetrieveAllCategorie() {
		List<Categorie> cats = categorieService.getAllCategories();
		Assert.assertNotNull(cats);
	}

	@Test
	public void test5DeleteCategorie() {
		categorieService.deleteCategorie(1);
		Assert.assertNull(categorieService.getCategorieById(1));
	}
}
