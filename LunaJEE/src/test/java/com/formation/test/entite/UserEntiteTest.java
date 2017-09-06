package com.formation.test.entite;

import org.junit.Assert;
import org.junit.Test;

import com.formation.entite.User;


public class UserEntiteTest {

	@Test
	public void testGetUsername() {
		User user = new User("user", "mdp");
		Assert.assertEquals("user", user.getUsername());
	}
	@Test
	public void testGetMdp() {
		User user = new User("user", "mdp");
		Assert.assertEquals("mdp", user.getMdp());
	}
	@Test
	public void testSetUsername() {
		User user = new User("user", "mdp");
		user.setUsername("user2");
		Assert.assertEquals("user2", user.getUsername());
	}
	@Test
	public void testSetMdp() {
		User user = new User("user", "mdp");
		user.setMdp("mdp2");
		Assert.assertEquals("mdp2", user.getMdp());
	}

	
}
