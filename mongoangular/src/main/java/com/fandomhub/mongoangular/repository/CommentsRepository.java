package com.fandomhub.mongoangular.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.Comments;

public interface CommentsRepository extends MongoRepository<Comments, Integer>{

	public void deleteByPostid(int postid);

	public void deleteByCommenterid(int commenterid);
	
	public List<Comments> findAllByPostid(int postid);
}
