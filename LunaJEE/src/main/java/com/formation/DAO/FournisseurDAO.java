package com.formation.DAO;

import java.util.List;

import com.formation.entite.Fournisseur;


public interface FournisseurDAO {
	public List<Fournisseur> getAllFournisseur();
	public Fournisseur getFournisseurById(long id);
	public void addFournisseur(Fournisseur fournisseur);
	public void updateFournisseur(Fournisseur fournisseur);
	public void deleteFournisseur(long id);
}
