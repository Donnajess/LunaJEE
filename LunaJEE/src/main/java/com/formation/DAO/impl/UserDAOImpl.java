package com.formation.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.UserDAO;
import com.formation.entite.Adresse;
import com.formation.entite.Client;
import com.formation.entite.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getAllUser() {
		return this.sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getUserById(long id) {
		return this.sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Override
	public void deleteUser(long id) {
		User user = sessionFactory.getCurrentSession().get(User.class, id);
		this.sessionFactory.getCurrentSession().delete(user);
	}

}
