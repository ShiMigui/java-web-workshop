package com.shimigui.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shimigui.workshop.domain.Post;
import com.shimigui.workshop.resources.utils.URL;
import com.shimigui.workshop.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		return ResponseEntity.ok(service.findBy(id));
	}

	@GetMapping(value = "/title")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "q", defaultValue = "") String q) {
		q = URL.decodeparam(q);
		return ResponseEntity.ok(service.findByTitle(q));
	}
}
