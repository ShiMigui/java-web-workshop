package com.shimigui.workshop.dto;

import com.shimigui.workshop.domain.User;

public class AuthorDTO extends EntityDTO<User> {
	private static final long serialVersionUID = 1L;

	private String name;

	public AuthorDTO() {
	}

	public AuthorDTO(User obj) {
		setReference(obj);
	}

	public AuthorDTO(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public User toReference() {
		User user = new User();
		user.setId(getId());
		user.setName(getName());
		return user;
	}

	@Override
	public void setReference(User obj) {
		setId(obj.getId());
		setName(obj.getName());
	}
	
	public void setReference(AuthorDTO obj) {
		setId(obj.getId());
		setName(obj.getName());
	}
}
