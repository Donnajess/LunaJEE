package com.formation.test.service;

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
import com.formation.services.ClientService;
import com.formation.services.CommandeService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientServiceTest {

	private static ApplicationContext context;
	private static ClientService clientService;
	private static AdresseDAO adresseDAO;
	private static CommandeService commandeService;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		adresseDAO = (AdresseDAO) context.getBean("adresseDAO");
		clientService = (ClientService) context.getBean("clientService");
		commandeService = (CommandeService) context.getBean("commandeService");
	}

	
	@Test
	public void test1AddClient() {
//		Adresse adr = new Adresse("35 rue peupliers", "59000", "Lille");
//		adresseDAO.addAdresse(adr);
		Instant inst = Instant.now();
		Client cli = new Client("Malleret", "Kevin", true, inst, adresseDAO.getAdresseById(1));
		clientService.addClient(cli);
		Assert.assertEquals(1, clientService.getAllClient().size());
	}

	@Test
	public void test2UpdateClient() {
		Client cli = clientService.getClientById(1);
		cli.setNom("Mich");
		clientService.updateClient(cli);
		Assert.assertEquals(cli.getNom(), clientService.getClientById(1).getNom());
	}

	@Test
	public void test3RetrieveClient() {
		Client cli = clientService.getClientById(1);
		Assert.assertNotNull(cli);
	}

	@Test
	public void test4RetrieveAllClient() {
		List<Client> clients = clientService.getAllClient();
		Assert.assertNotNull(clients);
	}

	@Test
	public void test5DeleteClient() {
		List<Ligne> lignes = new ArrayList<Ligne>();
		Commande c = new Commande(clientService.getClientById(1), "Cheques", LocalDateTime.now(), lignes);
		commandeService.addCommande(c);
		clientService.deleteClient(1);
		Assert.assertNull(clientService.getClientById(1));
	}

}
