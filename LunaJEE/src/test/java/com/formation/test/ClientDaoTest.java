package com.formation.test;

import java.time.Instant;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.AdresseDAO;
import com.formation.DAO.ClientDAO;
import com.formation.entite.Adresse;
import com.formation.entite.Client;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientDaoTest {

	private static ApplicationContext context;
	private static ClientDAO clientDAO;
	private static AdresseDAO adresseDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		adresseDAO = (AdresseDAO) context.getBean("adresseDAO");
		clientDAO = (ClientDAO) context.getBean("clientDAO");
	}

	@Test
	public void test1AddClient() {
		Adresse adr = new Adresse("35 rue peupliers", "59000", "Lille");
		adresseDAO.addAdresse(adr);
		Instant inst = Instant.now();
		Client cli = new Client("Malleret", "Kevin", true, inst, adr);
		clientDAO.addClient(cli);
		Assert.assertEquals(1, clientDAO.getAllClient().size());
	}

	@Test
	public void test2UpdateClient() {
		Client cli = clientDAO.getClientById(2);
		cli.setNom("Mich");
		clientDAO.updateClient(cli);
		Assert.assertEquals(cli.getNom(), clientDAO.getClientById(2).getNom());
	}

	@Test
	public void test3RetrieveClient() {
		Client cli = clientDAO.getClientById(2);
		Assert.assertNotNull(cli);
	}

	@Test
	public void test4RetrieveAllClient() {
		List<Client> clients = clientDAO.getAllClient();
		Assert.assertNotNull(clients);
	}

	@Test
	public void test5DeleteAdresse() {
		clientDAO.deleteClient(2);
		Assert.assertNull(clientDAO.getClientById(2));
	}

}
