package com.formation.entite;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	@Basic
	private String designation;

	public Categorie() {
		super();
	}

	public String getCode() {
		return code;
	}

	public Categorie setCode(String code) {
		this.code = code;
		return this;
	}

	public String getDesignation() {
		return designation;
	}

	public Categorie setDesignation(String designation) {
		this.designation = designation;
		return this;
	}
}