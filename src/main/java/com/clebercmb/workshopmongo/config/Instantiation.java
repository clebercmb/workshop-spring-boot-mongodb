package com.clebercmb.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.clebercmb.workshopmongo.domain.User;
import com.clebercmb.workshopmongo.repository.UserRepository;

@Configuration  
public class Instantiation implements CommandLineRunner{

	@Autowired 
	private UserRepository userRepository;  //Injection to make database connection
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		var maria = new User(null, "Maria Brown", "maria@gmail.com");
		var alex = new User(null, "Alex Green", "alex@gmail.com");
		var bob = new User(null, "Bob Grey", "bob@gmail.com");		
		var cleber = new User(null, "Clebe Barbosa", "cleber@gmail.com");	
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob, cleber));
		
	}

}
