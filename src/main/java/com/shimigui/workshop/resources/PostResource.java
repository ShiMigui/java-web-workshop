package com.shimigui.workshop.resources;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shimigui.workshop.domain.Post;
import com.shimigui.workshop.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<Stream<Post>> findAll() {
		return ResponseEntity.ok(service.findAll().stream());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		return ResponseEntity.ok(service.findBy(id));
	}
}
