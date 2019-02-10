package com.clebercmb.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clebercmb.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
