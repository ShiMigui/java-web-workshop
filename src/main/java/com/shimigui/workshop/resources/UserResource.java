package com.shimigui.workshop.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shimigui.workshop.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>();

		list.add(new User("asasdasdfaf", "Miguel Nascimento dos Santos", "miguel.nasto@gmail.com"));
		list.add(new User("asasdasdfaf", "Maria Green", "maria@gmail.com"));
		list.add(new User("asasdasdfaf", "Alex Brown", "alex@gmail.com"));

		return ResponseEntity.ok().body(list);
	}
}
