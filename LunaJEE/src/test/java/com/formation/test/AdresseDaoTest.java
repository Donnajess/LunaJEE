package com.formation.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.AdresseDAO;
import com.formation.entite.Adresse;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdresseDaoTest {

	private static ApplicationContext context;
	private static AdresseDAO adresseDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		adresseDAO = (AdresseDAO) context.getBean("adresseDAO");
	}

	@Test
	public void test1AddAdresse() {
		Adresse adresse = new Adresse("35 rue peupliers", "59000", "Lille");
		adresseDAO.addAdresse(adresse);
		Assert.assertEquals(1, adresseDAO.getAllAdresse().size());
	}

	@Test
	public void test2UpdateAdresse() {
		Adresse adresse = adresseDAO.getAdresseById(1);
		adresse.setRue("35 rue machins");
		adresseDAO.updateAdresse(adresse);
		Assert.assertEquals("35 rue machins", adresseDAO.getAdresseById(1).getRue());
	}

	@Test
	public void test3RetrieveAdresse() {
		Adresse adresse = adresseDAO.getAdresseById(1);
		Assert.assertNotNull(adresse);
	}

	@Test
	public void test4RetrieveAllAdresse() {
		List<Adresse> adresses = adresseDAO.getAllAdresse();
		Assert.assertNotNull(adresses);
	}

	@Test
	public void test5DeleteAdresse() {
		adresseDAO.deleteAdresse(1);
		Adresse adresse = adresseDAO.getAdresseById(1);
		Assert.assertNull(adresse);
	}
}
