package com.shimigui.workshop.dto;

import java.io.Serializable;
import java.time.Instant;

import com.shimigui.workshop.domain.User;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Instant date;
	private AuthorDTO author = new AuthorDTO();

	public CommentDTO() {
	}
	
	public CommentDTO(Instant date, User author, String text) {
		this.author.setReference(author);
		setText(text);
		this.date = date;
	}

	public String getText() {
		return text.trim();
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}
}
