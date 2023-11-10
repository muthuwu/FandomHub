package com.fandomhub.mongoangular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandomhub.mongoangular.model.lastid;

public interface LastIdRepository extends MongoRepository<lastid, Integer>{
}
