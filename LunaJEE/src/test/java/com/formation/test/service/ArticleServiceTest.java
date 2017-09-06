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
public class ArticleServiceTest {

	private static ApplicationContext context;
	private static ArticleService articleService;
	private static CategorieService categorieService;
	private static CommandeService commandeService;
	private static ClientService clientService;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		articleService = (ArticleService) context.getBean("articleService");
		categorieService = (CategorieService) context.getBean("categorieService");
		commandeService = (CommandeService) context.getBean("commandeService");
		clientService = (ClientService) context.getBean("clientService");
	}
	

	@Test
	public void test1AddArticle() {
		Categorie categorie = new Categorie("Electroménager");
		categorieService.addCategorie(categorie);
		Instant instant = Instant.now();
		Article article = new Article(categorie, "Machine à laver", 15, 144.99, instant);
		articleService.addArticle(article);
		Assert.assertEquals(1, articleService.getAllArticles().size());
	}
	
	@Test
	public void test2updateArticle() {
		List<Article> articleList = articleService.getAllArticles();
		Assert.assertEquals(1, articleList.size());
		Article articleExpected = articleList.get(0);
		articleExpected.setDesignation("Ballon de foot");
		articleService.updateArticle(articleExpected);
		Article articleResult = articleService.getArticleById(articleExpected.getCode());		
		Assert.assertEquals(articleExpected.getDesignation(), articleResult.getDesignation());
	}
	
	@Test
	public void test3getAllArticle() {
		List<Article> articleList = articleService.getAllArticles();
		Assert.assertEquals(1, articleList.size());
		Article articleExpected = articleList.get(0);
		Article articleResult = articleService.getArticleById(articleExpected.getCode());	
		Assert.assertEquals(articleExpected.getCode(), articleResult.getCode());
	}
	
	@Test
	public void test4getArticleById() {
		Article articleExpected = articleService.getArticleById(2);
		long id = articleExpected.getCode();
		Assert.assertEquals(2, id);
	}
	
	@Test
	public void test5deleteArticle() {
		List<Article> articleList = articleService.getAllArticles();
		Assert.assertEquals(1, articleList.size());
		Article articleExpected = articleList.get(0);
		List<Ligne> l = new ArrayList<Ligne>();
		Client cli = new Client();
		clientService.addClient(cli);
		Commande c =  new Commande(cli,"c",LocalDateTime.now(),l);
		Ligne ligne = new Ligne(articleExpected, 5);
		c.ajouter(ligne);
		commandeService.addCommande(c);
		long id = articleExpected.getCode();
		articleService.deleteArticle(id);
		Article articleResult = articleService.getArticleById(articleExpected.getCode());	
		Assert.assertEquals(articleResult, null);
	}
}
