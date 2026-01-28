package com.felipeoliveira.mongodbproject.resources;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipeoliveira.mongodbproject.domain.Post;
import com.felipeoliveira.mongodbproject.domain.User;
import com.felipeoliveira.mongodbproject.dto.UserDTO;
import com.felipeoliveira.mongodbproject.resources.util.URL;
import com.felipeoliveira.mongodbproject.services.PostService;
import com.felipeoliveira.mongodbproject.services.UserService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // get to obtain information in rest projects
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET) // get to obtain information in rest projects
	
	//requestparam porque irá retornar a partir de um parâmetro ?text=
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
