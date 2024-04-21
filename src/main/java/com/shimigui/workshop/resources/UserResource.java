package com.shimigui.workshop.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shimigui.workshop.domain.Post;
import com.shimigui.workshop.domain.User;
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
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		return ResponseEntity.ok(new UserDTO(service.findBy(id)));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
		User obj = service.insert(dto.getReference());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteBy(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO dto, @PathVariable String id) {
		User ref = dto.getReference();
		ref.setId(id);
		dto.setReference(service.update(ref));

		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		return ResponseEntity.ok(service.findBy(id).getPosts());
	}
}
