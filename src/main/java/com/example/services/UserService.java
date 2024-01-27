package com.example.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.dto.UserDTO;
import com.example.repositories.UserRepository;
import com.example.services.exception.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findById(String id) {
		try {
			Optional<User> userOptional =  userRepository.findById(id);
			return userOptional.get();
			
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public User fromDto(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	

}
