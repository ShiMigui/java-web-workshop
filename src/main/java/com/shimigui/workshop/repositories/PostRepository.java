package com.shimigui.workshop.repositories;

import org.springframework.stereotype.Repository;

import com.shimigui.workshop.domain.Post;

@Repository
public interface PostRepository extends EntityRepository<Post> {

}
