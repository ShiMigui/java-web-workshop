package com.shimigui.workshop.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shimigui.workshop.domain.Post;
import com.shimigui.workshop.repositories.PostRepository;

@Service
public final class PostService extends EntityService<Post> {
	private PostRepository repository;
	
	public PostService(@Autowired PostRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public List<Post> findByTitle(String title){
		return repository.findByTitleContainingIgnoreCase(title);
	}
	
	public List<Post> fullSearch(String text, Instant minDate, Instant maxDate){
//		maxDate= maxDate.plusSeconds((24 * 60 * 60));
		return repository.fullSearch(text, minDate, maxDate);
	}

	@Override
	protected void updateData(Post mirror, Post ref) {
		mirror.setTitle(ref.getTitle());
		mirror.setBody(ref.getBody());
		mirror.setAuthor(ref.getAuthor());
	}
}
