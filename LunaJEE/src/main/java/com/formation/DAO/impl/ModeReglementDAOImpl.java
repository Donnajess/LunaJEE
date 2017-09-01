package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.ModeReglementDAO;
import com.formation.entite.ModeReglements;

@Repository("modeReglementDAO")
@Transactional
public class ModeReglementDAOImpl implements ModeReglementDAO {

	@Autowired  
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ModeReglements> getAllModeReglements() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from ModeReglements").list();
	}

	@Override
	public ModeReglements getModeReglementById(long id) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().get(ModeReglements.class, id);
	}

	@Override
	public void addModeReglement(ModeReglements modeReglement) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(modeReglement);
	}

	@Override
	public void updateModeReglement(ModeReglements modeReglement) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(modeReglement);
	}

	@Override
	public void deleteModeReglement(long id) {
		// TODO Auto-generated method stub
		ModeReglements modeReglement = sessionFactory.getCurrentSession().get(ModeReglements.class, id);
		this.sessionFactory.getCurrentSession().delete(modeReglement);
	}

}
