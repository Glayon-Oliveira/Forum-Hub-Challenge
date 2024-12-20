package com.lmlasmo.forum.dto.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmlasmo.forum.model.Users;

public class ProfileDTO {

	@JsonProperty
	private int id;	
	
	@JsonProperty("profile_name")
	private String profileName;
	
	public ProfileDTO() {}
	
	public ProfileDTO(Users user) {
		this.id = user.getId();
		this.profileName = user.getProfile().getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}	
	
}
