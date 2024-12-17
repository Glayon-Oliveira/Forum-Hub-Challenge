package com.lmlasmo.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmlasmo.forum.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	public List<Users> findByUsername(String username);
	
	public Users findByEmailIgnoreCase(String email);	
	
	public boolean existsByUsername(String username);
	
	public boolean existsByEmailIgnoreCase(String email);
}
