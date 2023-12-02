package com.fandomhub.mongoangular.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.ForumsDTO;

public interface ForumsRepository extends MongoRepository<ForumsDTO, Integer>{
	public List<ForumsDTO> findByOwnerid(int ownerid);
	public void deleteByOwnerid(int ownerid);
	
}
