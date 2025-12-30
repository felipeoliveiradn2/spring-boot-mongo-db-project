package com.felipeoliveira.mongodbproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeoliveira.mongodbproject.domain.User;
import com.felipeoliveira.mongodbproject.dto.UserDTO;
import com.felipeoliveira.mongodbproject.repository.UserRepository;
import com.felipeoliveira.mongodbproject.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired //auto-inject dependency Spring Boot
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();		
	}
	
	//método findById que irá retornar o usuário recebendo o string id como argumento

	public User findById(String id) {
	    Optional<User> user = repo.findById(id);
	    if (user == null || user.isEmpty()) {
	        throw new ObjectNotFoundException("Objeto não encontrado");
	    }
	    return user.get();
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User (objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
