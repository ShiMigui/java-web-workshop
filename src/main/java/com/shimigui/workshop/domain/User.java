package com.shimigui.workshop.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User extends Entity<User> {
	private static final long serialVersionUID = 1L;

	private String name;
	private String email;

	public User() {
	}

	public User(String id, String name, String email) {
		setId(id);
		setName(name);
		setEmail(email);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
