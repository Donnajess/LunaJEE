package com.formation.services;

import java.util.List;

import com.formation.entite.Article;

public interface ArticleService {
	public List<Article> getAllArticles();

	public Article getArticleById(long code);

	public void addArticle(Article article);

	public void updateArticle(Article article);

	public void deleteArticle(long code);
}
