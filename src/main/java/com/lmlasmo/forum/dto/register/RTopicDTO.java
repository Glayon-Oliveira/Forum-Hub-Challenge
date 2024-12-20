package com.lmlasmo.forum.dto.register;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class RTopicDTO {

	@JsonProperty
	@NotBlank
	private String title;
	
	@JsonProperty
	@NotBlank
	private String message;
	
	@JsonProperty	
	private int author;
		
	@JsonProperty	
	@Min(1)
	private int course;
	
	public RTopicDTO() {}

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
	
}
