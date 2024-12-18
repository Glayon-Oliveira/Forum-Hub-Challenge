package com.lmlasmo.forum.dto.register;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class SignupDTO {

	@JsonProperty
	@NotBlank
	private String username;
	
	@JsonProperty
	@Email
	@NotBlank
	private String email;
	
	@JsonProperty
	@NotBlank
	@Min(8)
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}	
	
}
