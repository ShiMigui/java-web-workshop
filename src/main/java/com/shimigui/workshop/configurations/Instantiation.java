package com.shimigui.workshop.configurations;

import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.shimigui.workshop.domain.User;
import com.shimigui.workshop.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository users;

	@Override
	public void run(String... args) throws Exception {
		users.deleteAll();
		
		List<User> usersList = new ArrayList<>();

		usersList.add(new User(null, "Miguel Nascimento dos Santos", "miguel@gmail.com"));
		usersList.add(new User(null, "Maria da Silva", "maria@gmail.com"));
		usersList.add(new User(null, "João Oliveira", "joao@gmail.com"));
		usersList.add(new User(null, "Ana Souza", "ana@gmail.com"));
		usersList.add(new User(null, "Pedro Fernandes", "pedro@gmail.com"));
		usersList.add(new User(null, "Juliana Costa", "juliana@gmail.com"));
		usersList.add(new User(null, "Lucas Pereira", "lucas@gmail.com"));
		usersList.add(new User(null, "Carla Santos", "carla@gmail.com"));
		usersList.add(new User(null, "Rafaela Martins", "rafaela@gmail.com"));
		usersList.add(new User(null, "Rodrigo Almeida", "rodrigo@gmail.com"));
		usersList.add(new User(null, "Amanda Ferreira", "amanda@gmail.com"));

		users.saveAll(usersList);
	}

}
