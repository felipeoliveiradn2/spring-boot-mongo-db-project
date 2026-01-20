package com.felipeoliveira.mongodbproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeoliveira.mongodbproject.domain.Post;
import com.felipeoliveira.mongodbproject.domain.User;
import com.felipeoliveira.mongodbproject.repository.PostRepository;
import com.felipeoliveira.mongodbproject.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired //auto-inject dependency Spring Boot
	private PostRepository repo;
	
	//método findById que irá retornar o usuário recebendo o string id como argumento

	public Post findById(String id) {
	    return repo.findById(id)
	        .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}