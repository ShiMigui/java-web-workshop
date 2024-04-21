package com.shimigui.workshop.repositories;

import org.springframework.stereotype.Repository;

import com.shimigui.workshop.domain.User;

@Repository
public interface UserRepository extends EntityRepository<User> {

}
