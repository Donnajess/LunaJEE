package com.formation.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

		@SuppressWarnings("unused")
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		private Long id;
		@NotEmpty(message="Please enter an username")
		private String username;
		@NotEmpty(message="Please enter a password")
		private String mdp;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getMdp() {
			return mdp;
		}

		public void setMdp(String mdp) {
			this.mdp = mdp;
		}
		
		public User() {
		}
		
		public User(String username, String mdp) {
			super();
			setUsername(username);
			setMdp(mdp);
		}
}
