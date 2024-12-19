package com.lmlasmo.forum.model;

import java.time.LocalDateTime;

import com.lmlasmo.forum.dto.register.RResponseDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "responses")
public class Responses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String message;
	
	@Column(name = "creation_date", nullable = false)
	private LocalDateTime creationDate;
	
	@Column(nullable = false)
	private boolean solution = false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "topic", nullable = false)
	private Topics topic;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author", nullable = false)
	private Users author;
	
	public Responses() {}

	public Responses(RResponseDTO rResponse) {
		this.message = rResponse.getMessage();
		this.creationDate = LocalDateTime.now();
		this.topic = new Topics();
		this.topic.setId(rResponse.getTopic());
		this.author = new Users();
		this.author.setId(rResponse.getAuthor());		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isSolution() {
		return solution;
	}

	public void setSolution(boolean solution) {
		this.solution = solution;
	}

	public Topics getTopic() {
		return topic;
	}

	public void setTopic(Topics topic) {
		this.topic = topic;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}
		
}
