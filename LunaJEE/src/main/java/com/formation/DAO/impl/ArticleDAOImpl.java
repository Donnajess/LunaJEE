package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.ArticleDAO;
import com.formation.entite.Article;
import com.formation.entite.Client;
import com.formation.entite.Commande;
import com.formation.entite.Ligne;

@Repository("articleDAO")
@Transactional
public class ArticleDAOImpl implements ArticleDAO {
	
	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Article> getAllArticles() {
		return this.sessionFactory.getCurrentSession().createQuery("from Article").list();
	}

	@Override
	public Article getArticleById(long code) {
		return this.sessionFactory.getCurrentSession().get(Article.class, code);
	}

	@Override
	public void addArticle(Article article) {
		this.sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public void updateArticle(Article article) {
		this.sessionFactory.getCurrentSession().update(article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteArticle(long code) {
		List<Commande> commandes = this.sessionFactory.getCurrentSession().createQuery("from Commande").list();
		Article article = sessionFactory.getCurrentSession().get(Article.class, code);
		for(Commande c : commandes){
			for(Ligne l : c.getLignes()){
				if(l.getArticle().getCode() == article.getCode()){
					this.sessionFactory.getCurrentSession().delete(c);
				}
			}
		}
		this.sessionFactory.getCurrentSession().delete(article);
	}

}
