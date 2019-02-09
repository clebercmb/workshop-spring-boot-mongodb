package com.clebercmb.workshopmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clebercmb.workshopmongo.dto.UserDTO;
import com.clebercmb.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	
	@Autowired
	private UserService service;  // Injection service
	
	@RequestMapping(method=RequestMethod.GET)  //End point path to get all  users.  default path = /users
	public ResponseEntity<List<UserDTO>> findAll() {
		
		var userList = service.findAll(); 
		var listDto = userList.stream().map(p -> new UserDTO(p)).collect(Collectors.toList());
				
		return ResponseEntity.ok().body(listDto);
	}

	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //End point path to get user by id. Path = /users/id
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		
		var user = service.findById(id);
				
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		var user = service.userFromDTO(objDto);
		user = service.insert(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		System.out.println(">>>" + uri);
		
		return ResponseEntity.created(uri).build(); //ResponseEntity.created(uri) will return an empty answer with the code 201
													//and a header having the location of the new resource created
														
	}	
	
}
