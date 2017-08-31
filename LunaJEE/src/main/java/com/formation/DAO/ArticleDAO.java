package com.formation.DAO;

import java.util.List;

import com.formation.entite.Article;

public interface ArticleDAO {
	
	public List<Article> getAllArticles();
	public Article getArticleById(int code);
	public void addArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(int code);
}
