package com.lmlasmo.forum.dto.generic;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmlasmo.forum.model.Responses;

public class ResponseDTO {

	@JsonProperty
	private int id;
	
	@JsonProperty
	private String message;
		
	@JsonProperty("creation_date")
	private LocalDateTime creationDate;
	
	@JsonProperty
	private boolean solution = false;
	
	@JsonProperty
	private int topic;
	
	@JsonProperty
	private int author;
	
	public ResponseDTO() {}
	
	public ResponseDTO(Responses response) {
		this.id = response.getId();
		this.message = response.getMessage();
		this.creationDate = response.getCreationDate();
		this.solution = response.isSolution();
		this.topic = response.getTopic().getId();
		this.author = response.getAuthor().getId();
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

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

}
