package com.formation.test.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.AdresseDAO;
import com.formation.actions.AffichageCommandeAction;
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
public class AffichageCommandeActionTest {

	private static AffichageCommandeAction affichageCommandeAction;
	private static ApplicationContext context;
	private static CommandeService commandeService;
	private static ArticleService articleService;
	private static CategorieService categorieService;
	private static ClientService clientService;
	private static AdresseDAO adresseDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		affichageCommandeAction = new AffichageCommandeAction();
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		commandeService = (CommandeService) context.getBean("commandeService");
		articleService = (ArticleService) context.getBean("articleService");
		categorieService = (CategorieService) context.getBean("categorieService");
		clientService = (ClientService) context.getBean("clientService");
		adresseDAO = (AdresseDAO) context.getBean("adresseDAO");
	}
	
	@Test
	public void test0execute(){
		affichageCommandeAction.setCommandeList(commandeService.getAllCommande());
		affichageCommandeAction.getCommandeList();
		try {
			assertEquals("success", affichageCommandeAction.execute());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1Delete(){
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Client client = new Client("test", "test", true, instant, adresseDAO.getAdresseById(1));
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
		affichageCommandeAction.setCommande(commande);
		assertNotNull(affichageCommandeAction.getCommande());
		affichageCommandeAction.setCode("4");
		assertNotNull(affichageCommandeAction.getCode());
		assertNotNull(affichageCommandeAction.getModel());
		affichageCommandeAction.setCommandeService(commandeService);
		assertNotNull(affichageCommandeAction.getCommandeService());
		assertEquals("exec", affichageCommandeAction.delete());
		clientService.deleteClient(1);
	}
}
