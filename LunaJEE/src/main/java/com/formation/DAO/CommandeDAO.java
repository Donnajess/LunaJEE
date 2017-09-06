package com.formation.DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import com.formation.entite.Commande;

public interface CommandeDAO {
	
	public List<Commande> getAllCommande();
	public Commande getCommandeById(long code);
	public void addCommande(Commande commande);
	public void deleteCommande(long code);
	public void setSessionFactory(SessionFactory sessionFactory);
	public SessionFactory getSessionFactory();
}
