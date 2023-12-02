package com.fandomhub.mongoangular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.UserDTO;

public interface UserRepository extends MongoRepository<UserDTO, Integer>{
	public UserDTO findByPhonenumber(long phonenumber);
}
