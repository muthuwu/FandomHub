package com.fandomhub.mongoangular.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.CommentsDTO;

public interface CommentsRepository extends MongoRepository<CommentsDTO, Integer>{

	public void deleteByPostid(int postid);

	public void deleteByCommenterid(int commenterid);
	
	public List<CommentsDTO> findAllByPostid(int postid);
}
