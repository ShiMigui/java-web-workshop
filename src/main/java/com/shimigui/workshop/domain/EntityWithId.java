package com.shimigui.workshop.domain;

import java.io.Serializable;
import java.util.Objects;

public class EntityWithId<E extends EntityWithId<E>> implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		E other = (E) obj;
		return Objects.equals(id, other.id);
	}
}
