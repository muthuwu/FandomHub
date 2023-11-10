package com.fandomhub.mongoangular.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.Forums;

public interface ForumsRepository extends MongoRepository<Forums, Integer>{
	public List<Forums> findByOwnerid(int ownerid);
	
}
