package com.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.DAO.CommandeDAO;
import com.formation.entite.Commande;
import com.formation.services.CommandeService;

@Service("commandeService")
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	private CommandeDAO commandeDAO;
	
	@Override
	public List<Commande> getAllCommande() {
		return commandeDAO.getAllCommande();
	}

	@Override
	public Commande getCommandeById(long code) {
		return commandeDAO.getCommandeById(code);
	}

	@Override
	public void addCommande(Commande commande) {
		commandeDAO.addCommande(commande);
	}

	@Override
	public void deleteCommande(long code) {
		
		commandeDAO.deleteCommande(code);
	}

}
