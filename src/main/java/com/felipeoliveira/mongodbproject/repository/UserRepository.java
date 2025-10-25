package com.felipeoliveira.mongodbproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipeoliveira.mongodbproject.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	
	
}
