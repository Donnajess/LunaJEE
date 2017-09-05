package com.formation.actions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.DAO.ArticleDAO;
import com.formation.DAO.CategorieDAO;
import com.formation.entite.Article;
import com.formation.entite.Categorie;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ListArticleAction extends ActionSupport implements ModelDriven<Article> {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private CategorieDAO categorieDAO;
	private Article article;
	private Categorie categorie;
	private List<Article> listArticles;
	private List<Categorie> listCategories;
	private List<String> listDesignations;
	private Long code;
	private String cat;
	
	public String add() {
		Instant instant = Instant.now();
		article.setDate(instant);
		listCategories = categorieDAO.getAllCategorie();
		long codeCat = Long.parseLong(cat);
		Categorie c = categorieDAO.getCategorieById(codeCat);
		
		article.setReference(c);
		articleDAO.addArticle(article);
		
		return SUCCESS;
	}
	
	public String listArticle() {
		listArticles = articleDAO.getAllArticles();
		listCategories = categorieDAO.getAllCategorie();
		
		return SUCCESS;
	}
	
	public String delete() {
		articleDAO.deleteArticle(code);
		
		return SUCCESS;
	}
	
	

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Categorie> getListCategories() {
		return listCategories;
	}

	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public List<String> getListDesignations() {
		return listDesignations;
	}

	public void setListDesignations(List<String> listDesignations) {
		this.listDesignations = listDesignations;
	}

	@Override
	public Article getModel() {
		return article;
	}

}
