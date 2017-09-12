package com.formation.test.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.List;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.AdresseDAO;
import com.formation.actions.AffichageCommandeAction;
import com.formation.actions.ListClientAction;
import com.formation.actions.ListCommandeAction;
import com.formation.entite.Adresse;
import com.formation.entite.Article;
import com.formation.entite.Categorie;
import com.formation.entite.Client;
import com.formation.entite.Ligne;
import com.formation.services.ArticleService;
import com.formation.services.CategorieService;
import com.formation.services.ClientService;
import com.formation.services.CommandeService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListCommandeActionTest {

	private static ListCommandeAction listCommandeAction;
	private static ApplicationContext context;
	private static CommandeService commandeService;
	private static ArticleService articleService;
	private static CategorieService categorieService;
	private static ClientService clientService;
	private static AdresseDAO adresseDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		listCommandeAction = new ListCommandeAction();
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		commandeService = (CommandeService) context.getBean("commandeService");
		articleService = (ArticleService) context.getBean("articleService");
		categorieService = (CategorieService) context.getBean("categorieService");
		clientService = (ClientService) context.getBean("clientService");
		adresseDAO = (AdresseDAO) context.getBean("adresseDAO");
	}
	
	@Test
	public void test0donneList(){
		listCommandeAction.setArticleService(articleService);
		listCommandeAction.setClientService(clientService);
		assertNotNull(listCommandeAction.getClientService());
		assertNotNull(listCommandeAction.getArticleService());
		listCommandeAction.setCommandeList(new ArrayList<Ligne>());
		assertNotNull(listCommandeAction.getCommandeList());
		listCommandeAction.setListArticle(new ArrayList<Article>());
		listCommandeAction.setListClient(new ArrayList<Client>());
		assertEquals(listCommandeAction.donneListes(), "success");
	}
	
	@Test
	public void test1executeList() throws Exception{
		assertEquals(listCommandeAction.execute(), "success");
	}

	@Test
	public void test2add(){
		Categorie c = new Categorie("Jouet");
		categorieService.addCategorie(c);
		articleService.addArticle(new Article(c, "Ballon", 5, 5.50, Instant.now()));
		listCommandeAction.setArticle("2");
		listCommandeAction.setQuantite("5");
		assertEquals(listCommandeAction.add(), "exec");
	}
	
	@Test
	public void test3delete(){
		listCommandeAction.setIdentifiant("1");
		assertEquals(listCommandeAction.delete(), "exec");
	}
	
	@Test
	public void test3valider(){
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Adresse a = new Adresse("", "", "");
		adresseDAO.addAdresse(a);
		Client client = new Client("test", "test", true, instant, a);
		clientService.addClient(client);
		listCommandeAction.setClient("2");
		listCommandeAction.setMontant(5.50);
		listCommandeAction.setCommandeService(commandeService);
		assertEquals(listCommandeAction.valide(), "valider");
	}
	
	@Test
	public void test4lister(){
		Instant instant = Instant.now();
		assertEquals(listCommandeAction.lister(), "valider");
		articleService.deleteArticle(2);
		categorieService.deleteCategorie(1);
		clientService.deleteClient(4);
	}
	
	@Test
	public void test5autres(){
		listCommandeAction.setLigne(new Ligne(null, 0));
		assertNotNull(listCommandeAction.getLigne());
		listCommandeAction.setListReglements(new ArrayList<String>());
		assertNotNull(listCommandeAction.getListReglements());
		assertNotNull(listCommandeAction.getCommandeService());
		assertNotNull(listCommandeAction.getArticle());
		assertNotNull(listCommandeAction.getQuantite());
		assertNotNull(listCommandeAction.getListArticle());
		assertNotNull(listCommandeAction.getListClient());
		assertNotNull(listCommandeAction.getIdentifiant());
		assertNotNull(listCommandeAction.getMontant());
		listCommandeAction.setClient("5");
		assertNotNull(listCommandeAction.getClient());
		listCommandeAction.setModeReglement("Cheques");
		assertNotNull(listCommandeAction.getModeReglement());
	}
}
