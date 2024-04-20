package com.shimigui.workshop.resources;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shimigui.workshop.dto.UserDTO;
import com.shimigui.workshop.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<Stream<UserDTO>> findAll() {
		Stream<UserDTO> list = service.findAll().stream().map(x -> new UserDTO(x));
		return ResponseEntity.ok().body(list);
	}
}
