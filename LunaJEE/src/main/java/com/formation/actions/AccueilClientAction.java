package com.formation.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
@Action("/client")
@Results({
	@Result(name = "success", location = "/accueilClient.jsp"),
})
public class AccueilClientAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
