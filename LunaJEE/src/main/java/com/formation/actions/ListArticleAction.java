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
	private long code;
	
	public String add() {
		Instant instant = Instant.now();
		article.setDate(instant);
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
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public long getCode() {
		return code;
	}

	public void setCode(long code) {
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

	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}

}
