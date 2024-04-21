package com.shimigui.workshop.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.shimigui.workshop.dto.AuthorDTO;
import com.shimigui.workshop.dto.CommentDTO;

@Document
public class Post extends Entity<Post> {
	private static final long serialVersionUID = 1L;

	private Instant date;
	private String title;
	private String body;

	private AuthorDTO author = new AuthorDTO();
	private List<CommentDTO> comments = new ArrayList<>();

	public Post() {
	}

	public Post(String id, Instant date, String title, String body, User author) {
		setId(id);
		setDate(date);
		setBody(body);
		setTitle(title);
		setAuthor(author);
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title.trim();
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body.trim();
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author.setReference(author);
	}

	public void setAuthor(AuthorDTO author) {
		this.author.setReference(author);
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void addComment(CommentDTO comment) {
		comments.add(comment);
	}

	public void removeComment(CommentDTO comment) {
		comments.remove(comment);
	}
}
