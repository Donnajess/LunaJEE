package com.formation.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.entite.Article;

@Repository("articleDAO")
@Transactional
public class ArticleDAOImpl implements ArticleDAO {

	/* sessionFactory est injecté avec @Autowired, on ajoute son Setter */
	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Article").list();
	}

	@Override
	public Article getArticleById(int code) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().get(Article.class, code);
	}

	@Override
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public void deleteArticle(int code) {
		// TODO Auto-generated method stub
		Article article = sessionFactory.getCurrentSession().get(Article.class, code);
		this.sessionFactory.getCurrentSession().delete(article);
	}

}
