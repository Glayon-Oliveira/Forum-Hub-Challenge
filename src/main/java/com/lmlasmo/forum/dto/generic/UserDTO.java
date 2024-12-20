package com.lmlasmo.forum.dto.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmlasmo.forum.model.Users;

public class UserDTO extends ProfileDTO{

	@JsonProperty
	private String username;
	
	@JsonProperty
	private String email;	
	
	public UserDTO() {}
	
	public UserDTO(Users user) {	
		super(user);
		this.username = user.getUsername();
		this.email = user.getEmail();		
	}	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
