package com.formation.test;

import java.time.Instant;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

import com.formation.DAO.ArticleDAO;
import com.formation.DAO.CategorieDAO;
import com.formation.entite.Article;
import com.formation.entite.Categorie;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleDaoTest {

	private static ApplicationContext context;
	private static ArticleDAO articleDAO;
	private static CategorieDAO categorieDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		articleDAO = (ArticleDAO) context.getBean("articleDAO");
		categorieDAO = (CategorieDAO) context.getBean("categorieDAO");
	}
	
	
	@Test
	public void test1AddArticle() {
		Categorie categorie = new Categorie("Electroménager");
		
		//categorieDAO.addCategorie(categorie);
		
		Instant instant = Instant.now();
		Article article = new Article(categorie, "Machine à laver", 15, 144.99, instant);
		articleDAO.addArticle(article);
		Assert.assertEquals(4, articleDAO.getAllArticles().size());
	}
	
	@Test
	public void test2updateArticle() {
		List<Article> articleList = articleDAO.getAllArticles();
		Assert.assertEquals(1, articleList.size());
		Article articleExpected = articleList.get(0);
		articleExpected.setDesignation("Ballon de foot");
		articleDAO.updateArticle(articleExpected);
		Article articleResult = articleDAO.getArticleById(articleExpected.getCode());		
		Assert.assertEquals(articleExpected.getDesignation(), articleResult.getDesignation());
	}
	
	@Test
	public void test3getAllArticle() {
		List<Article> articleList = articleDAO.getAllArticles();
		Assert.assertEquals(3, articleList.size());
		Article articleExpected = articleList.get(0);
		Article articleResult = articleDAO.getArticleById(articleExpected.getCode());	
		Assert.assertEquals(articleExpected.getCode(), articleResult.getCode());
	}
	
	@Test
	public void test4getArticleById() {
		Article articleExpected = articleDAO.getArticleById(2);
		long id = articleExpected.getCode();
		Assert.assertEquals(43, id);
	}
	
	@Test
	public void test5deleteArticle() {
		List<Article> articleList = articleDAO.getAllArticles();
		Assert.assertEquals(3, articleList.size());
		Article articleExpected = articleList.get(0);
		long id = articleExpected.getCode();
		articleDAO.deleteArticle(id);
		Article articleResult = articleDAO.getArticleById(articleExpected.getCode());	
		Assert.assertEquals(articleResult, null);
	}
}
