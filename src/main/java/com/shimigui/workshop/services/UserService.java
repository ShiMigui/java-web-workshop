package com.shimigui.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shimigui.workshop.domain.User;
import com.shimigui.workshop.repositories.UserRepository;

@Service
public final class UserService extends EntityService<User> {
	public UserService(@Autowired UserRepository repository) {
		super(repository);
	}
	
	@Override
	protected void updateData(User mirror, User ref) {
		mirror.setEmail(ref.getEmail());
		mirror.setName(ref.getName());
	}
}
