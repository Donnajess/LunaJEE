package com.formation.actions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.DAO.ArticleDAO;
import com.formation.entite.Article;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ListArticleAction extends ActionSupport implements ModelDriven<Article> {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArticleDAO articleDAO;
	private Article article = new Article();
	private List<Article> listArticles;
	
	public String add() {
		Instant instant = Instant.now();
		article.setDate(instant);
		articleDAO.addArticle(article);
		
		return SUCCESS;
	}
	
	public String listArticle() {
		listArticles = articleDAO.getAllArticles();
		
		return SUCCESS;
	}
	
	public String delete() {
		long code = article.getCode();
		System.out.println(code);
		articleDAO.deleteArticle(code);
		System.out.println(article.getCategorie());
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
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

	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}

}
