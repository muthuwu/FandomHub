package com.fandomhub.mongoangular.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.PostsDTO;


public interface PostsRepository extends MongoRepository<PostsDTO, Integer>{

	public void deleteByOwnerid(int ownerid);
}
