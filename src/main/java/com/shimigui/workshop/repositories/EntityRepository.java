package com.shimigui.workshop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shimigui.workshop.domain.Entity;

public interface EntityRepository<E extends Entity<E>> extends MongoRepository<E, String>{

}
