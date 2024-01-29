package com.example.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String text;
	private LocalDateTime data;
	private AuthorDTO author;
	
	public CommentDTO() {}

	public CommentDTO(String text, LocalDateTime data, AuthorDTO author) {
		this.text = text;
		this.data = data;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	
	
	

}
