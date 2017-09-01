package com.formation.DAO;

import java.util.List;

import com.formation.entite.ModeReglements;

public interface ModeReglementDAO {
	public List<ModeReglements> getAllModeReglements();
	public ModeReglements getModeReglementById(long id);
	public void addModeReglement(ModeReglements modeReglement);
	public void updateModeReglement(ModeReglements modeReglement);
	public void deleteModeReglement(long id);
}
