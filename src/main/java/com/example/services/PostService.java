package com.example.services;

import java.time.LocalDateTime;
import java.util.List;
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
	
	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, LocalDateTime minDate, LocalDateTime maxDate){
		maxDate.plusSeconds(24 * 60 * 60);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	

}
