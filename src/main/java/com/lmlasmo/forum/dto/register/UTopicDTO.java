package com.lmlasmo.forum.dto.register;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class UTopicDTO {

	@JsonProperty	
	private String title;
	
	@JsonProperty
	private String message;
	
	public UTopicDTO() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {		
		this.title = (title != null) ? title : "";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = (message != null) ? message : "";
	}	
	
}
