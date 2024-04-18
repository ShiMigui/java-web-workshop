package com.shimigui.workshop.domain;

import java.io.Serializable;
import java.util.Objects;

public class Entity<ID, E extends Entity<ID, E>> implements Serializable {
	private static final long serialVersionUID = 1L;
	protected ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
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
