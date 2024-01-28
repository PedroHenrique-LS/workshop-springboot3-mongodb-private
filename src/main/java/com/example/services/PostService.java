package com.example.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Post;
import com.example.repositories.PostRepository;
import com.example.services.exception.ObjectNotFoundException;


@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		try {
			Optional<Post> postOptional =  postRepository.findById(id);
			return postOptional.get();
			
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Post não encontrado");
		}
	}
	

}
