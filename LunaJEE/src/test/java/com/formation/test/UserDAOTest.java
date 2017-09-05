package com.formation.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.UserDAO;
import com.formation.entite.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTest {

		private static ApplicationContext context;
		private static UserDAO userDAO;

		@BeforeClass
		public static void oneTimeSetUp() {
			context = new ClassPathXmlApplicationContext("/applicationContext.xml");
			userDAO = (UserDAO) context.getBean("userDAO");
		}

		@Test
		public void test1AddUser() {
			User user = new User("toto", "toto");
			userDAO.addUser(user);
			Assert.assertEquals(1, userDAO.getAllUser().size());
		}

		@Test
		public void test2UpdateUser() {
			User user = userDAO.getUserById(1);
			user.setUsername("popo");
			userDAO.updateUser(user);
			Assert.assertEquals("popo", userDAO.getUserById(1).getUsername());
		}

		@Test
		public void test3RetrieveUser() {
			User user = userDAO.getUserById(1);
			Assert.assertNotNull(user);
		}

		@Test
		public void test4RetrieveAllUser() {
			List<User> users = userDAO.getAllUser();
			Assert.assertNotNull(users);
		}

		@Test
		public void test5DeleteUser() {
			userDAO.deleteUser(1);
			User user = userDAO.getUserById(1);
			Assert.assertNull(user);
		}
}
