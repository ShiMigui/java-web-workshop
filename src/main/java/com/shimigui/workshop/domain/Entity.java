package com.shimigui.workshop.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;

public class Entity<E extends Entity<E>> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass())
			return false;
		if (this == obj)
			return true;
		E other = (E) obj;
		return id.equals(other.id);
	}
}
