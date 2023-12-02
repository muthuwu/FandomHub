package com.fandomhub.mongoangular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.LastidDTO;

public interface LastIdRepository extends MongoRepository<LastidDTO, Integer>{
}
