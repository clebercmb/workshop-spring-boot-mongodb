package com.clebercmb.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clebercmb.workshopmongo.domain.User;
import com.clebercmb.workshopmongo.repository.UserRepository;
import com.clebercmb.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		
		System.out.println(">>>>"+obj);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
}
