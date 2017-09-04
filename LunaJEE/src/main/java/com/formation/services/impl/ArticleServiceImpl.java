package com.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.DAO.ArticleDAO;
import com.formation.entite.Article;
import com.formation.services.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDAO articleDAO;
	
	@Override
	public List<Article> getAllArticles() {
		return articleDAO.getAllArticles();
	}

	@Override
	public Article getArticleById(long code) {
		return articleDAO.getArticleById(code);
	}

	@Override
	public void addArticle(Article article) {
		articleDAO.addArticle(article);
	}

	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}

	@Override
	public void deleteArticle(long code) {
		articleDAO.deleteArticle(code);
	}

}
