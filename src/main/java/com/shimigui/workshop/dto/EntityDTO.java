package com.shimigui.workshop.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shimigui.workshop.domain.Entity;

public abstract class EntityDTO<E extends Entity<E>> implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@JsonIgnore
	public abstract E getReference();
	
	public abstract void setReference(E obj);
}
