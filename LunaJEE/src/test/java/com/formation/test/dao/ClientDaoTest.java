package com.formation.test.dao;

import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.AdresseDAO;
import com.formation.DAO.ClientDAO;
import com.formation.DAO.CommandeDAO;
import com.formation.entite.Adresse;
import com.formation.entite.Client;
import com.formation.entite.Commande;
import com.formation.entite.Ligne;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientDaoTest {

	private static ApplicationContext context;
	private static ClientDAO clientDAO;
	private static AdresseDAO adresseDAO;
	private static CommandeDAO commandeDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		adresseDAO = (AdresseDAO) context.getBean("adresseDAO");
		clientDAO = (ClientDAO) context.getBean("clientDAO");
		commandeDAO = (CommandeDAO) context.getBean("commandeDAO");
	}

	@Test
	public void test0SessionFactory(){
		SessionFactory sf = clientDAO.getSessionFactory();
		clientDAO.setSessionFactory(sf);
		assertNotNull(clientDAO.getSessionFactory());
	}
	
	@Test
	public void test1AddClient() {
//		Adresse adr = new Adresse("35 rue peupliers", "59000", "Lille");
//		adresseDAO.addAdresse(adr);
		Instant inst = Instant.now();
		Client cli = new Client("Malleret", "Kevin", true, inst, adresseDAO.getAdresseById(1));
		clientDAO.addClient(cli);
		Assert.assertEquals(1, clientDAO.getAllClient().size());
	}

	@Test
	public void test2UpdateClient() {
		Client cli = clientDAO.getClientById(1);
		cli.setNom("Mich");
		clientDAO.updateClient(cli);
		Assert.assertEquals(cli.getNom(), clientDAO.getClientById(1).getNom());
	}

	@Test
	public void test3RetrieveClient() {
		Client cli = clientDAO.getClientById(1);
		Assert.assertNotNull(cli);
	}

	@Test
	public void test4RetrieveAllClient() {
		List<Client> clients = clientDAO.getAllClient();
		Assert.assertNotNull(clients);
	}

	@Test
	public void test5DeleteClient() {
		List<Ligne> lignes = new ArrayList<Ligne>();
		Commande c = new Commande(clientDAO.getClientById(1), "Cheques", LocalDateTime.now(), lignes);
		commandeDAO.addCommande(c);
		clientDAO.deleteClient(1);
		Assert.assertNull(clientDAO.getClientById(1));
	}

}
