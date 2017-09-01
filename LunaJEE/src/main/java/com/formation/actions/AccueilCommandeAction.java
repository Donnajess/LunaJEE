package com.formation.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Action("/commande")
@Results({
	@Result(name = "success", location = "/accueilCommande.jsp"),
})
public class AccueilCommandeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
