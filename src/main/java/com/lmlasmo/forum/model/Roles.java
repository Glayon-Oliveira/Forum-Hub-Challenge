package com.lmlasmo.forum.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles implements GrantedAuthority{
	
	private static final long serialVersionUID = -2185728561966977970L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@OneToMany(mappedBy = "role")
	private Set<Users> users = new HashSet<>();
	
	public Roles() {}	

	@Override
	public String getAuthority() {
		return this.getRole().name();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}		
	
}
