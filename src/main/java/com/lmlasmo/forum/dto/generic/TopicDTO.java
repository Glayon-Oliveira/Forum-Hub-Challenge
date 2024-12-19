package com.lmlasmo.forum.dto.generic;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmlasmo.forum.model.Topics;

public class TopicDTO {

	@JsonProperty
	private int id;
	
	@JsonProperty
	private String title;
	
	@JsonProperty
	private String message;
	
	@JsonProperty
	private LocalDateTime creationDate;
		
	@JsonProperty
	private boolean solved;
	
	@JsonProperty
	private int author;
	
	@JsonProperty
	private int course;
	
	@JsonProperty
	private int countResponses;
	
	public TopicDTO() {}
	
	public TopicDTO(Topics topic, int countResponses) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.creationDate = topic.getCreationDate();
		this.solved = topic.isSolved();
		this.course = topic.getCourse().getId();
		this.author = topic.getAuthor().getId();
		this.countResponses = countResponses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public int getCountResponses() {
		return countResponses;
	}

	public void setCountResponses(int countResponses) {
		this.countResponses = countResponses;
	}	
	
}
