package com.shimigui.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shimigui.workshop.domain.User;
import com.shimigui.workshop.repositories.UserRepository;
import com.shimigui.workshop.services.exceptions.NotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findBy(String id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void deleteBy(String id) {
		findBy(id);
		repository.deleteById(id);;
	}
	
	public User update(User ref) {
		User mirror = findBy(ref.getId());
		updateData(mirror, ref);
		return repository.save(mirror);
	}

	private void updateData(User mirror, User ref) {
		mirror.setEmail(ref.getEmail());
		mirror.setName(ref.getName());
	}
}
