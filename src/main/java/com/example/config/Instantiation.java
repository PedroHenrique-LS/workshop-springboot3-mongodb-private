package com.example.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.domain.User;
import com.example.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
//		userRepository.deleteAll();
//		
//		User user1 = new User(null, "Maria Brown", "maria@gmail.com");
//		User user2 = new User(null, "Alex Green", "alex@gmail.com");
//		User user3 = new User(null, "Pedro Henrique", "pedro@gmail.com");
//		
//		userRepository.saveAll(Arrays.asList(user1, user2, user3));
	}

}
