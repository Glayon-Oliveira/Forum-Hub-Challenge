package com.lmlasmo.forum.dto.register;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

	@JsonProperty
	@Email
	@NotBlank
	private String email;
	
	@JsonProperty
	@NotBlank
	@Min(8)
	private String password;
	
	public LoginDTO() {}

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
	
}
