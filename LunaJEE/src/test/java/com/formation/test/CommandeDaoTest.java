package com.formation.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

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
import com.formation.DAO.LigneDAO;
import com.formation.DAO.ModeReglementDAO;
import com.formation.entite.Adresse;
import com.formation.entite.Article;
import com.formation.entite.Categorie;
import com.formation.entite.Client;
import com.formation.entite.Commande;
import com.formation.entite.Ligne;
import com.formation.entite.ModeReglements;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommandeDaoTest {
	private static ApplicationContext context;
	private static CommandeDAO commandeDAO;
	private static ArticleDAO articleDAO;
	private static CategorieDAO categorieDAO;
	private static ClientDAO clientDAO;
	private static ModeReglementDAO modeReglementDAO;
	private static AdresseDAO adresseDAO;
	private static LigneDAO ligneDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		commandeDAO = (CommandeDAO) context.getBean("commandeDAO");
		articleDAO = (ArticleDAO) context.getBean("articleDAO");
		categorieDAO = (CategorieDAO) context.getBean("categorieDAO");
		clientDAO = (ClientDAO) context.getBean("clientDAO");
		modeReglementDAO = (ModeReglementDAO) context.getBean("modeReglementDAO");
		adresseDAO = (AdresseDAO) context.getBean("adresseDAO");
		ligneDAO = (LigneDAO) context.getBean("ligneDAO");
	}
	
	
	@Test
	public void test1AddCommande() {
		LocalDate date = LocalDate.now();
		Instant instant = Instant.now();
		LocalDateTime datetime = LocalDateTime.now();
		Adresse adresse = new Adresse("rue","code","ville");
		adresseDAO.addAdresse(adresse);
		Client client = new Client("test", "test", true, adresse, date);
		clientDAO.addClient(client);
		Categorie categorie = new Categorie("Sport");
		categorieDAO.addCategorie(categorie);
		Article article = new Article(categorie, "Ballon foot", 15, 14.99, instant);
		articleDAO.addArticle(article);
		ModeReglements modeReglement = new ModeReglements("CB");
		modeReglementDAO.addModeReglement(modeReglement);
		List<Ligne> listLignes = new ArrayList<Ligne>(); 
		Ligne ligne = new Ligne(article, 15);
		listLignes.add(ligne);
		ligneDAO.addLigne(ligne);
		Commande commande = new Commande(client,modeReglement, datetime, listLignes);
		commandeDAO.addCommande(commande);
		Assert.assertEquals(1, commandeDAO.getAllCommande().size());
	}
	

}
