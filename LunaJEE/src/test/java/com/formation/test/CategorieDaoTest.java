package com.formation.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.CategorieDAO;
import com.formation.entite.Categorie;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategorieDaoTest {

	private static ApplicationContext context;
	private static CategorieDAO categorieDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		categorieDAO = (CategorieDAO) context.getBean("categorieDAO");
	}

	@Test
	public void test1AddCategorie() {
		Categorie cat = new Categorie("Electromenager");
		categorieDAO.addCategorie(cat);
		Assert.assertEquals(1, categorieDAO.getAllCategorie().size());
	}

	@Test
	public void test2UpdateCategorie() {
		Categorie cat = categorieDAO.getCategorieById(1);
		cat.setDesignation("Jouet");
		categorieDAO.updateCategorie(cat);
		Assert.assertEquals(cat.getDesignation(), categorieDAO.getCategorieById(1).getDesignation());
	}

	@Test
	public void test3RetrieveCategorie() {
		Categorie cat = categorieDAO.getCategorieById(1);
		Assert.assertNotNull(cat);
	}

	@Test
	public void test4RetrieveAllCategorie() {
		List<Categorie> cats = categorieDAO.getAllCategorie();
		Assert.assertNotNull(cats);
	}

	@Test
	public void test5DeleteCategorie() {
		categorieDAO.deleteCategorie(1);
		Assert.assertNull(categorieDAO.getCategorieById(1));
	}
}
