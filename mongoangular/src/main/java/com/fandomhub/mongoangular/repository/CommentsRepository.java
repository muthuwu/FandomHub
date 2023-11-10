package com.fandomhub.mongoangular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.Comments;

public interface CommentsRepository extends MongoRepository<Comments, Integer>{

}
