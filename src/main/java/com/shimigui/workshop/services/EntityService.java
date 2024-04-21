package com.shimigui.workshop.services;

import java.util.List;

import com.shimigui.workshop.domain.Entity;
import com.shimigui.workshop.repositories.EntityRepository;
import com.shimigui.workshop.services.exceptions.NotFoundException;

public abstract class EntityService<E extends Entity<E>> {
	private EntityRepository<E> repository;

	public EntityService(EntityRepository<E> repository) {
		this.repository = repository;
	}

	public List<E> findAll() {
		return repository.findAll();
	}

	public E findBy(String id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public E insert(E obj) {
		return repository.insert(obj);
	}

	public void deleteBy(String id) {
		findBy(id);
		repository.deleteById(id);
		;
	}

	public E update(E ref) {
		E mirror = findBy(ref.getId());
		updateData(mirror, ref);
		return repository.save(mirror);
	}

	protected abstract void updateData(E mirror, E ref);
}
