package com.formation.actions;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.DAO.ArticleDAO;
import com.formation.DAO.CategorieDAO;
import com.formation.entite.Article;
import com.formation.entite.Categorie;
import com.formation.services.ArticleService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateArticleAction extends ActionSupport implements ModelDriven<Article>  {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategorieDAO categorieDAO;
	private Article article;
	private Categorie categorie;
	private static Long code;
	private List<Categorie> listCategories;
	private String cat;
	

	
	public String update() {
		Instant instant = Instant.now();
		article.setDate(instant);
		listCategories = categorieDAO.getAllCategorie();
		long codeCat = Long.parseLong(cat);
		Categorie c = categorieDAO.getCategorieById(codeCat);
		
		getArticle().setCode(code);
		getArticle().setDate(instant);
		getArticle().setDesignation(article.getDesignation());	
		getArticle().setQuantite(article.getQuantite());
		getArticle().setPrixUnitaire(article.getPrixUnitaire());
		getArticle().setReference(c);
		articleService.updateArticle(getArticle());
				
		return SUCCESS;
	}
	
	public String majChamp() {
		Article art = articleService.getArticleById(code);
		setArticle(art);

		listCategories = categorieDAO.getAllCategorie();
		
		return SUCCESS;
	}
	
	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* Getter 
	 * 		AND
	 * 			Setters */

	
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

	public void setCode(Long code1) {
		code = code1;
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

	

	
}
