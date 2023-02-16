package com.technoelevate.postsharing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.technoelevate.postsharing.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserById(String id);
}
