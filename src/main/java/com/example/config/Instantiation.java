package com.example.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.domain.Post;
import com.example.domain.User;
import com.example.dto.AuthorDTO;
import com.example.repositories.PostRepository;
import com.example.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com");
		User user2 = new User(null, "Alex Green", "alex@gmail.com");
		User user3 = new User(null, "Bob grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Post post1 = new Post(null, Instant.parse("2018-03-21T00:00:00Z"), "Partiu viagem!", "Vou viajar para São paulo, abraços", new AuthorDTO(user1));
		Post post2 = new Post(null, Instant.parse("2018-03-23T00:00:00Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user1));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
