package com.felipeoliveira.mongodbproject.resources;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipeoliveira.mongodbproject.domain.User;
import com.felipeoliveira.mongodbproject.dto.UserDTO;
import com.felipeoliveira.mongodbproject.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // get to obtain information in rest projects
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // get to obtain information in rest projects
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);		
		return ResponseEntity.ok().body(new UserDTO(obj));		
	}
	
	@RequestMapping(method = RequestMethod.POST) // get to obtain information in rest projects
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		//esse comando URI vai pegar o novo endereço do objeto inserido 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//created retorna o código 201, que é o código de retorno http quando você cria um novo recurso
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		//noContent().build() irá retornar o código 204
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT) // get to obtain information in rest projects
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		obj.setId(id);
		//esse comando URI vai pegar o novo endereço do objeto inserido 
		obj = service.update(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//created retorna o código 201, que é o código de retorno http quando você cria um novo recurso
		return ResponseEntity.created(uri).build();
	}
}
