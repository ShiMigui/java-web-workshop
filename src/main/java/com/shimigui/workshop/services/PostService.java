package com.shimigui.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shimigui.workshop.domain.Post;
import com.shimigui.workshop.repositories.PostRepository;

@Service
public final class PostService extends EntityService<Post> {
	public PostService(@Autowired PostRepository repository) {
		super(repository);
	}
	
	@Override
	protected void updateData(Post mirror, Post ref) {
		mirror.setTitle(ref.getTitle());
		mirror.setBody(ref.getBody());
		mirror.setAuthor(ref.getAuthor());
	}
}
