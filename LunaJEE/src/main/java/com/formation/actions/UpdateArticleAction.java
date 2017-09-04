package com.formation.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.DAO.ArticleDAO;
import com.formation.DAO.CategorieDAO;
import com.formation.entite.Article;
import com.formation.entite.Categorie;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateArticleAction extends ActionSupport implements ModelDriven<Article>  {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private CategorieDAO categorieDAO;
	private Article article;
	private Categorie categorie;
	private Long code;
	
	
	public String update() {
		Article art = articleDAO.getArticleById(code);
		setArticle(art);
		return SUCCESS;
	}
	
	public String majChamp() {
		getArticle().setDesignation(article.getDesignation());	
		getArticle().setQuantite(article.getQuantite());
		getArticle().setPrixUnitaire(article.getPrixUnitaire());
		getArticle().setReference(article.getCategorie());
		
		return SUCCESS;
	}
	
	
	
	public Article getArticle() {
		return article;
	}



	public void setArticle(Article article) {
		this.article = article;
	}



	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Long getCode() {
		return code;
	}



	public void setCode(Long code) {
		this.code = code;
	}



	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}

	
}
