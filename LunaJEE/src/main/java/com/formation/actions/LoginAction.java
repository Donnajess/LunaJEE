package com.formation.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.DAO.UserDAO;
import com.formation.entite.User;
import com.formation.services.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Action("/login")
@Results({
	@Result(name = "success", location = "/accueil.jsp"),
	@Result(name = "error", location = "/login.jsp"),
})
public class LoginAction extends ActionSupport  implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	private User user;

	@Autowired
	private UserService userService;

	public UserService getUserDAO() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		List<User> users = userService.getAllUser();
		for (User u : users) {
			if(u.getUsername().equals(user.getUsername()) && (u.getMdp().equals(user.getMdp()))){
				return SUCCESS;
			}
		}
		return ERROR;
	}

	@Override
	public User getModel() {
		return user;
	}
}
