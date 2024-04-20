package com.shimigui.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shimigui.workshop.domain.User;
import com.shimigui.workshop.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findBy(String id) {
		return repository.findById(id).get();
	}
}
