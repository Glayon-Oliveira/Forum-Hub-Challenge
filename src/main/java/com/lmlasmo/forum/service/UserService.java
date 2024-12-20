package com.lmlasmo.forum.service;

import java.util.List;
import java.util.Optional;

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
	
	public UserDTO findById(int id) {
		
		Optional<Users> user = repository.findById(id);
		
		if(user.isPresent()) {
			return new UserDTO(user.get());
		}
		
		return null;
	}
	
	public UserDTO findByEmail(String email) {
		
		Optional<Users> user = repository.findByEmailIgnoreCase(email);
		
		if(user.isPresent()) {
			return new UserDTO(user.get());
		}
		
		return null;
	}

	public List<UserDTO> findAllById(Integer[] ids) {			
				
		return repository.findAllById(List.of(ids)).stream()
				.map(u -> new UserDTO(u))
				.toList();
	}
	
	public UsersRepository getRepository() {
		return this.repository;
	}
	
}
