package com.lmlasmo.forum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lmlasmo.forum.dto.generic.UserDTO;
import com.lmlasmo.forum.dto.register.SignupDTO;
import com.lmlasmo.forum.model.Users;
import com.lmlasmo.forum.repository.UsersRepository;

@Service
@Transactional
public class UserService {

	private UsersRepository repository;
	
	public UserService(UsersRepository repository) {
		this.repository = repository;
	}
	
	public UserDTO save(Users user) {
		
		repository.save(user);
		
		return new UserDTO(user);
	}
	
	public UserDTO save(SignupDTO signup) {
		
		Users user = new Users(signup);				
		
		return save(user);		
	}	
	
	public boolean deleteById(int id) {
		
		repository.deleteById(id);
		
		return !repository.existsById(id);
	}
	
	public UsersRepository getRepository() {
		return this.repository;
	}
	
}
