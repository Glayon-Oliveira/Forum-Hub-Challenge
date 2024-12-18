package com.lmlasmo.forum.dto.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmlasmo.forum.model.Users;

public class UserDTO {

	@JsonProperty
	private int id;
	
	@JsonProperty
	private String username;
	
	@JsonProperty
	private String email;
	
	@JsonProperty("profile_name")
	private String profileName;
	
	public UserDTO() {}
	
	public UserDTO(Users user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.profileName = user.getProfile().getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
}
