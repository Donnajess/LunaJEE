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

@Action("updateArticle")
@Results({ @Result(name = "success", location = "/modifArticle.jsp"),
	@Result(name = "accueil", type = "redirectAction", location = "listArticle.action"), })
public class UpdateArticleAction extends ActionSupport implements ModelDriven<Article>  {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategorieService categorieService;
	private Article article;
	private Categorie categorie;
	private static Long code;
	private List<Categorie> listCategories;
	private String cat;
	

	@Override
	public String execute() throws Exception {
		Article art = articleService.getArticleById(code);
		setArticle(art);
		listCategories = categorieService.getAllCategories();
		
		return SUCCESS;
	}

	@Action("majArticle")
	public String update() {
		Instant instant = Instant.now();
		article.setDate(instant);
		listCategories = categorieService.getAllCategories();
		long codeCat = Long.parseLong(cat);
		Categorie c = categorieService.getCategorieById(codeCat);
		
		getArticle().setCode(code);
		getArticle().setDate(instant);
		getArticle().setDesignation(article.getDesignation());	
		getArticle().setQuantite(article.getQuantite());
		getArticle().setPrixUnitaire(article.getPrixUnitaire());
		getArticle().setReference(c);
		articleService.updateArticle(getArticle());
				
		return "accueil";
	}
	
	@Override
	public Article getModel() {
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
