package com.shimigui.workshop.resources;

import java.time.Instant;
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
	
	private static final Instant time = Instant.now().minusSeconds(31536000);

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		return ResponseEntity.ok(service.findBy(id));
	}

	@GetMapping(value = "/searchtitle")
	public ResponseEntity<List<Post>> searchBy(@RequestParam(value = "title", defaultValue = "") String title) {
		return ResponseEntity.ok(service.findByTitle(URL.decodeparam(title)));
	}

	@GetMapping(value = "/search")
	public ResponseEntity<List<Post>> searchBy(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max) {

		List<Post> posts = service.fullSearch(URL.decodeparam(text), URL.convertDate(min, time), URL.convertDate(max));
		return ResponseEntity.ok(posts);
	}
}
