package com.Luis.kenway.RETOC42.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

import com.Luis.kenway.RETOC42.model.User;

public interface UserCrudRepository extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
