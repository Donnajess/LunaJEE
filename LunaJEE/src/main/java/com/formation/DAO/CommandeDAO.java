package com.formation.DAO;

import java.util.List;

import com.formation.entite.Commande;

public interface CommandeDAO {
	
	public List<Commande> getAllCommande();
	public Commande getCommandeById(long code);
	public void addCommande(Commande commande);
	public void updateCommande(Commande commande);
	public void deleteCommande(long code);
}
