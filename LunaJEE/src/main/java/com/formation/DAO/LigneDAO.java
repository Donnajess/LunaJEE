package com.formation.DAO;

import java.util.List;

import com.formation.entite.Ligne;

public interface LigneDAO {
	public List<Ligne> getAllLigne();
	public Ligne getLigneById(long id);
	public void addLigne(Ligne ligne);
	public void updateLigne(Ligne ligne);
	public void deleteLigne(long id);
}
