package com.formation.test.service;

import static org.junit.Assert.assertEquals;
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
import com.formation.DAO.ArticleDAO;
import com.formation.DAO.CategorieDAO;
import com.formation.DAO.ClientDAO;
import com.formation.DAO.CommandeDAO;
import com.formation.entite.Adresse;
import com.formation.entite.Article;
import com.formation.entite.Categorie;
import com.formation.entite.Client;
import com.formation.entite.Commande;
import com.formation.entite.Ligne;
import com.formation.services.ArticleService;
import com.formation.services.CategorieService;
import com.formation.services.ClientService;
import com.formation.services.CommandeService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommandeServiceTest {
	private static ApplicationContext context;
	private static CommandeService commandeService;
	private static ArticleService articleService;
	private static CategorieService categorieService;
	private static ClientService clientService;
	private static AdresseDAO adresseDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		commandeService = (CommandeService) context.getBean("commandeService");
		articleService = (ArticleService) context.getBean("articleService");
		categorieService = (CategorieService) context.getBean("categorieService");
		clientService = (ClientService) context.getBean("clientService");
		adresseDAO = (AdresseDAO) context.getBean("adresseDAO");
	}
	
	@Test
	public void test1AddCommande() {
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Adresse adresse = new Adresse("rue","code","ville");
		adresseDAO.addAdresse(adresse);
		Client client = new Client("test", "test", true, instant, adresse);
		clientService.addClient(client);
		Categorie categorie = new Categorie("Sport");
		categorieService.addCategorie(categorie);
		Article article = new Article(categorie, "Ballon foot", 15, 14.99, instant);
		articleService.addArticle(article);
		List<Ligne> listLignes = new ArrayList<Ligne>(); 
		Commande commande = new Commande(client,"cheques", datetime, listLignes);
		Ligne ligne = new Ligne(article, 15);
		commande.ajouter(ligne);
		commandeService.addCommande(commande);
		Assert.assertEquals(1, commandeService.getAllCommande().size());
	}
	
	@Test
	public void test2RetrieveCommande() {
		Commande c = commandeService.getCommandeById(5);
		assertNotNull(c);
	}
	
	@Test
	public void test3RetrieveAllCommande() {
		List<Commande> c = commandeService.getAllCommande();
		assertNotNull(c);
	}
	
	@Test
	public void test4DeleteCommande() {
		commandeService.deleteCommande(5);
		List<Commande> c = commandeService.getAllCommande();
		assertEquals(0, c.size());
	}

}
