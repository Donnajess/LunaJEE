package com.formation.DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import com.formation.entite.Article;

public interface ArticleDAO {
	
	public List<Article> getAllArticles();
	public Article getArticleById(long code);
	public void addArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(long code);
	public void setSessionFactory(SessionFactory sessionFactory);
	public SessionFactory getSessionFactory();
}
