package com.shimigui.workshop.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User extends Entity<User> {
	private static final long serialVersionUID = 1L;

	private String name;
	private String email;

	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();

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

	public List<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public void addPost(Post p) {
		posts.add(p);
	}
	
	public void removePost(Post p) {
		posts.remove(p);
	}
}
