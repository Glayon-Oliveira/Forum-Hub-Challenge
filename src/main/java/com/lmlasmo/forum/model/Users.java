package com.lmlasmo.forum.model;

import java.util.HashSet;
import java.util.Set;

import com.lmlasmo.forum.dto.register.SignupDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.EAGER, cascade = {CascadeType.ALL})			
	private Profiles profile;
	
	@OneToMany(mappedBy = "author")
	private Set<Topics> topics = new HashSet<>();
	
	@OneToMany(mappedBy = "author")
	private Set<Responses> responses = new HashSet<>();
	
	public Users() {}
	
	public Users(SignupDTO signup) {
		this.username = signup.getUsername();
		this.email = signup.getEmail();
		this.password = signup.getPassword();
		this.profile = new Profiles(signup.getProfileName(), this);
	}

	@PrePersist
	@PreUpdate
	public void pre() {
		this.email = this.email.toLowerCase();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profiles getProfile() {
		return profile;
	}

	public void setProfile(Profiles profile) {
		this.profile = profile;
	}

	public Set<Topics> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topics> topics) {
		this.topics = topics;
	}

	public Set<Responses> getResponses() {
		return responses;
	}

	public void setResponses(Set<Responses> responses) {
		this.responses = responses;
	}	
	
}
