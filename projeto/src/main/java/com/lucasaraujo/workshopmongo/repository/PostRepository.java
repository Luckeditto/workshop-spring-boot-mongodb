package com.lucasaraujo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucasaraujo.workshopmongo.domain.Post;
import com.lucasaraujo.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}