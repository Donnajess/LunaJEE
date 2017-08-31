package com.formation.test;

import java.time.Instant;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.ArticleDAO;
import com.formation.entite.Article;
import com.formation.entite.Categorie;

public class ArticleDaoTest {

	private static ApplicationContext context;
	private static ArticleDAO articleDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		articleDAO = (ArticleDAO) context.getBean("articleDAO");
	}
	
	
	@Test
	public void testAddArticle() {
		Categorie categorie = new Categorie("Electrom�nager");
		Instant instant = Instant.now();
		Article article = new Article(categorie, "Machine � laver", 15, 144.99, instant);
		articleDAO.addArticle(article);
		Assert.assertEquals(1, articleDAO.getAllArticles().size());
	}
}
