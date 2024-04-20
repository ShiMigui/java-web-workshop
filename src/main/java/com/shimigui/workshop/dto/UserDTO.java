package com.shimigui.workshop.dto;

import com.shimigui.workshop.domain.Entity;
import com.shimigui.workshop.domain.User;

public class UserDTO extends Entity<User> {
	private static final long serialVersionUID = 1L;

	private String name;
	private String email;

	public UserDTO(String name, String email) {
		setName(name);
		setEmail(email);
	}

	public UserDTO(User obj) {
		setId(obj.getId());
		setName(obj.getName());
		setEmail(obj.getEmail());
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
