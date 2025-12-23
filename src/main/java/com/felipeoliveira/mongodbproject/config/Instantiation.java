package com.felipeoliveira.mongodbproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipeoliveira.mongodbproject.domain.User;
import com.felipeoliveira.mongodbproject.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Sanchez", "alex@gmail.com");
		User bob = new User(null, "Bruno Jose", "jose@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}
}