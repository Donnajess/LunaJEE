package com.formation.DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import com.formation.entite.User;

public interface UserDAO {
	public List<User> getAllUser();
	public User getUserById(long id);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(long id);
	public void setSessionFactory(SessionFactory sessionFactory);
	public SessionFactory getSessionFactory();
}
