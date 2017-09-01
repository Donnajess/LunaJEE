package com.formation.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.entite.Fournisseur;

public class FournisseurDAOImpl implements FournisseurDAO {

	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Fournisseur> getAllFournisseur() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Fournisseur").list();
	}

	@Override
	public Fournisseur getFournisseurById(long id) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().get(Fournisseur.class, id);
	}

	@Override
	public void addFournisseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(fournisseur);
	}

	@Override
	public void updateFournisseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(fournisseur);
	}

	@Override
	public void deleteFournisseur(long id) {
		// TODO Auto-generated method stub
		Fournisseur fournisseur = sessionFactory.getCurrentSession().get(Fournisseur.class, id);
		this.sessionFactory.getCurrentSession().delete(fournisseur);
	}

}
