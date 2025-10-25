package com.felipeoliveira.mongodbproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeoliveira.mongodbproject.domain.User;
import com.felipeoliveira.mongodbproject.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired //auto-inject dependency Spring Boot
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();		
	}
}
