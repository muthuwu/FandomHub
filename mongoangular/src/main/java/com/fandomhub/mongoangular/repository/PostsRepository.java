package com.fandomhub.mongoangular.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.Posts;


public interface PostsRepository extends MongoRepository<Posts, Integer>{

	public void deleteByOwnerid(int ownerid);
}
