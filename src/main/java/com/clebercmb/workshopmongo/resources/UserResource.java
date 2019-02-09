package com.clebercmb.workshopmongo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clebercmb.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {

		var userList = new ArrayList<User>();
		var maria = new User("1", "Maria Brown", "maria@gmail.com");
		var alex = new User("1", "Alex Green", "alex@gmail.com");
		
		userList.add(maria);
		userList.add(alex);
				
		return ResponseEntity.ok().body(userList);
	}
}
