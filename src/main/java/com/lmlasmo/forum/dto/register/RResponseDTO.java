package com.lmlasmo.forum.dto.register;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class RResponseDTO {
	
	@JsonProperty
	@NotBlank
	private String message;		
	
	@JsonProperty
	@Min(1)
	private int topic;
	
	@JsonProperty
	@Min(1)
	private int author;
	
	public RResponseDTO() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
