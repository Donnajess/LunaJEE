package com.formation.DAO;

import java.util.List;

import com.formation.entite.Adresse;

public interface AdresseDAO {
	public List<Adresse> getAllAdresse();
	public Adresse getAdresseById(long id);
	public void addAdresse(Adresse adresse);
	public void updateAdresse(Adresse adresse);
	public void deleteAdresse(long id);
}
