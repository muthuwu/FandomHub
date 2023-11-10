package com.fandomhub.mongoangular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	public User findByEmail(String email);
}
