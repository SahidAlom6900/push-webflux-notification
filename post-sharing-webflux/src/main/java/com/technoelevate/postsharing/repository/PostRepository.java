package com.technoelevate.postsharing.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.technoelevate.postsharing.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    Optional<Post> findPostById(String id);


}
