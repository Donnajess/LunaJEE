package com.formation.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.UserDAO;
import com.formation.entite.User;
import com.formation.services.UserService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

		private static ApplicationContext context;
		private static UserService userService;

		@BeforeClass
		public static void oneTimeSetUp() {
			context = new ClassPathXmlApplicationContext("/applicationContext.xml");
			userService = (UserService) context.getBean("userService");
		}

		@Test
		public void test1AddUser() {
			User user = new User("toto", "toto");
			userService.addUser(user);
			Assert.assertEquals(1, userService.getAllUser().size());
		}

		@Test
		public void test2UpdateUser() {
			User user = userService.getUserById(1);
			user.setUsername("popo");
			userService.updateUser(user);
			Assert.assertEquals("popo", userService.getUserById(1).getUsername());
		}

		@Test
		public void test3RetrieveUser() {
			User user = userService.getUserById(1);
			Assert.assertNotNull(user);
		}

		@Test
		public void test4RetrieveAllUser() {
			List<User> users = userService.getAllUser();
			Assert.assertNotNull(users);
		}

		@Test
		public void test5DeleteUser() {
			userService.deleteUser(1);
			User user = userService.getUserById(1);
			Assert.assertNull(user);
			user = new User("toto", "toto");
			userService.addUser(user);
		}
}
