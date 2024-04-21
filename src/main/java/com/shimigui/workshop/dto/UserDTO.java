package com.shimigui.workshop.dto;

import com.shimigui.workshop.domain.User;

public class UserDTO extends EntityDTO<User> {
	private static final long serialVersionUID = 1L;

	private String name;
	private String email;

	public UserDTO(String name, String email) {
		setName(name);
		setEmail(email);
	}

	public UserDTO(User obj) {
		setRefenrece(obj);
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

	@Override
	public void setRefenrece(User obj) {
		this.reference = obj;
		setId(obj.getId());
		setName(obj.getName());
		setEmail(obj.getEmail());
	}

	@Override
	public User getReference() {
		if(reference == null) 
			reference = new User(getId(), getName(), getEmail());
		return this.reference;
	}
}
