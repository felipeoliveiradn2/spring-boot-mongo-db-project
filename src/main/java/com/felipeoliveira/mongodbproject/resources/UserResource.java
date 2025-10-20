package com.felipeoliveira.mongodbproject.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipeoliveira.mongodbproject.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET) //get to obtain information in rest projects
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User alex = new User("2", "Alex Silva", "alex@gmail.com");
		List<User> list = new ArrayList<>(); // new ArrayList, because List is an Interface, so you can't just use, you need to create a "new ArrayList<>()"
		list.addAll(Arrays.asList(maria, alex)); //add the User names to the list
		return ResponseEntity.ok().body(list);
	}	
}
