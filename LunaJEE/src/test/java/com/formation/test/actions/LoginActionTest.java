package com.formation.test.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.DAO.UserDAO;
import com.formation.actions.LoginAction;
import com.formation.entite.User;
import com.formation.services.UserService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginActionTest {
	
	private static LoginAction loginAction;
	private static ApplicationContext context;
	private static UserService userService;

	@BeforeClass
	public static void oneTimeSetUp() {
		loginAction = new LoginAction();
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		userService = (UserService) context.getBean("userService");
	}

	@Test
	public void test0Execute() {
		User user = new User("toto","toto");
		userService.addUser(user);
		loginAction.setUser(user);
		loginAction.setUserService(userService);
		try {
			assertEquals("success" ,loginAction.execute());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user = new User("toto","popo");
		userService.addUser(user);
		loginAction.setUser(user);
		loginAction.setUserService(userService);
		try {
			assertEquals("error" ,loginAction.execute());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user = new User("","popo");
		userService.addUser(user);
		loginAction.setUser(user);
		loginAction.setUserService(userService);
		try {
			assertEquals("error" ,loginAction.execute());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user = new User("toto","");
		userService.addUser(user);
		loginAction.setUser(user);
		loginAction.setUserService(userService);
		try {
			assertEquals("error" ,loginAction.execute());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test1accueil() {
		assertEquals("success",loginAction.accueil());
		assertNotNull(loginAction.getUser());
		assertNotNull(loginAction.getUserDAO());
		assertNotNull(loginAction.getModel());
	}

}
