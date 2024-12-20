package com.lmlasmo.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lmlasmo.forum.dto.generic.UserDTO;
import com.lmlasmo.forum.dto.register.SignupDTO;
import com.lmlasmo.forum.model.Users;
import com.lmlasmo.forum.repository.RolesRepository;
import com.lmlasmo.forum.repository.UsersRepository;

@Service
@Transactional
public class UserService {

	private UsersRepository usersRepository;
	private RolesRepository rolesRepository;
	
	public UserService(UsersRepository usersRepository, RolesRepository rolesRepository) {
		this.usersRepository = usersRepository;
		this.rolesRepository = rolesRepository;
	}
	
	public UserDTO save(Users user) {
		
		if(user.getRole().getId() <= 0) {
			user.setRole(rolesRepository.findByRole(user.getRole().getRole()));
		}
		
		usersRepository.save(user);
		
		return new UserDTO(user);
	}
	
	public UserDTO save(SignupDTO signup) {
		
		Users user = new Users(signup);		
		user.setRole(rolesRepository.findByRole(signup.getRole()));		
		
		return save(user);		
	}	
	
	public boolean deleteById(int id) {
		
		usersRepository.deleteById(id);
		
		return !usersRepository.existsById(id);
	}
	
	public UserDTO findById(int id) {
		
		Optional<Users> user = usersRepository.findById(id);
		
		if(user.isPresent()) {
			return new UserDTO(user.get());
		}
		
		return null;
	}
	
	public UserDTO findByEmail(String email) {
		
		Optional<Users> user = usersRepository.findByEmailIgnoreCase(email);
		
		if(user.isPresent()) {
			return new UserDTO(user.get());
		}
		
		return null;
	}

	public List<UserDTO> findAllById(Integer[] ids) {			
				
		return usersRepository.findAllById(List.of(ids)).stream()
				.map(u -> new UserDTO(u))
				.toList();
	}
	
	public UsersRepository getRepository() {
		return this.usersRepository;
	}
	
}
