package com.formation.services;

import java.util.List;

import com.formation.entite.User;

public interface UserService {
	public List<User> getAllUser();

	public User getUserById(long id);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(long id);
}
