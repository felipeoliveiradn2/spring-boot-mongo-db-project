package com.felipeoliveira.mongodbproject.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipeoliveira.mongodbproject.domain.Post;
import com.felipeoliveira.mongodbproject.domain.User;
import com.felipeoliveira.mongodbproject.repository.PostRepository;
import com.felipeoliveira.mongodbproject.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Sanchez", "alex@gmail.com");
		User bob = new User(null, "Bruno Jose", "jose@gmail.com");

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo, abraços", maria);
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz hoje", maria);
		
		postRepository.saveAll(Arrays.asList(post1, post2));		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
		
	}
}