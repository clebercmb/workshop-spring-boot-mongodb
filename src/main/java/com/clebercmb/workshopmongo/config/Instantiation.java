package com.clebercmb.workshopmongo.config;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.clebercmb.workshopmongo.domain.Post;
import com.clebercmb.workshopmongo.domain.User;
import com.clebercmb.workshopmongo.dto.AuthorDTO;
import com.clebercmb.workshopmongo.repository.PostRepository;
import com.clebercmb.workshopmongo.repository.UserRepository;

@Configuration  
public class Instantiation implements CommandLineRunner{

	@Autowired 
	private UserRepository userRepository;  //Injection to make database connection
	
	@Autowired 
	private PostRepository postRepository;  //Injection to make database connection
	
	
	@Override
	public void run(String... args) throws Exception {
		
		ZoneId zone = ZoneId.of("GMT"); //Considering the Greenwich (of London) hour
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(zone);
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		var maria = new User(null, "Maria Brown", "maria@gmail.com");
		var alex = new User(null, "Alex Green", "alex@gmail.com");
		var bob = new User(null, "Bob Grey", "bob@gmail.com");		
		var cleber = new User(null, "Clebe Barbosa", "cleber@gmail.com");	
		userRepository.saveAll(Arrays.asList(maria, alex, bob, cleber));
		
		var post1 = new Post(null, LocalDate.parse("21/03/2018", formatter),"Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		var post2 = new Post(null, LocalDate.parse("23/03/2018", formatter),"Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
