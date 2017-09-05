package com.formation.actions;

import java.time.Instant;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.entite.Article;
import com.formation.entite.Categorie;
import com.formation.services.ArticleService;
import com.formation.services.CategorieService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Action("/listArticle")
@Results(@Result(name = "success", location = "/accueilArticle.jsp"))
public class ListArticleAction extends ActionSupport implements ModelDriven<Article> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategorieService categorieService;
	private Article article;
	private Categorie categorie;
	private List<Article> listArticles;
	private List<Categorie> listCategories;
	private List<String> listDesignations;
	private Long code;
	private String cat;

	
	@Action("addArticle")
	public String add() {
		Instant instant = Instant.now();
		article.setDate(instant);
		listCategories = categorieService.getAllCategories();
		long codeCat = Long.parseLong(cat);
		Categorie c = categorieService.getCategorieById(codeCat);

		article.setReference(c);
		articleService.addArticle(article);

		return SUCCESS;
	}
	
	@Action("listArticle")
	public String listArticle() {
		listArticles = articleService.getAllArticles();
		listCategories = categorieService.getAllCategories();

		return SUCCESS;
	}

	@Action("deleteArticle")
	public String delete() {
		articleService.deleteArticle(code);

		return SUCCESS;
	}

	
	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}
	

	/*
	 * Getter AND Setters
	 */

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

}
