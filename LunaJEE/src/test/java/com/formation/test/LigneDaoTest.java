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

import com.formation.DAO.ArticleDAO;
import com.formation.DAO.CategorieDAO;
import com.formation.DAO.LigneDAO;
import com.formation.entite.Article;
import com.formation.entite.Categorie;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LigneDaoTest {
	private static ApplicationContext context;
	private static LigneDAO ligneDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ligneDAO = (LigneDAO) context.getBean("ligneDAO");
	}
	
	
	@Test
	public void test1AddLigne() {
		
	}
}
