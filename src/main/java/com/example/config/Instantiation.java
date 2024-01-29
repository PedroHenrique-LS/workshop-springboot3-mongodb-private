package com.example.config;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.domain.Post;
import com.example.domain.User;
import com.example.dto.AuthorDTO;
import com.example.dto.CommentDTO;
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
		
		Post post1 = new Post(null, LocalDateTime.parse("2018-03-21T00:00:00"), "Partiu viagem!", "Vou viajar para São paulo, abraços", new AuthorDTO(user1));
		Post post2 = new Post(null, LocalDateTime.parse("2018-03-23T00:00:00"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user1));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		user1.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(user1);
		
		CommentDTO comment1 = new CommentDTO("Boa viagem!", LocalDateTime.parse("2018-03-21T08:10:00"), new AuthorDTO(user2));
		CommentDTO comment2 = new CommentDTO("Aproveite!", LocalDateTime.parse("2018-03-21T08:30:00"), new AuthorDTO(user3));
		CommentDTO comment3 = new CommentDTO("Tenha um bom dia!", LocalDateTime.parse("2018-03-23T08:00:00"), new AuthorDTO(user2));
		
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().add(comment3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
