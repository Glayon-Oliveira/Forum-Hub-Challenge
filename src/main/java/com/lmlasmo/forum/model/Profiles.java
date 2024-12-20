package com.lmlasmo.forum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profiles {

	@Id	
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Users user;
	
	public Profiles() {}

	public Profiles(String profileName, Users user) {		
		this.name = profileName;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}		
	
}
