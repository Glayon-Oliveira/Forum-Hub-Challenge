package com.lmlasmo.forum.dto.register;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class SignupDTO extends LoginDTO{

	@JsonProperty
	@NotBlank
	private String username;	

	@JsonProperty("profile_name")
	@NotBlank
	private String profileName;
	
	public SignupDTO() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}	
	
}
