package com.lmlasmo.forum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lmlasmo.forum.model.Users;
import com.lmlasmo.forum.repository.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private UsersRepository repository;
	
	@Autowired
	public UserDetailsServiceImpl(UsersRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<Users> user = repository.findByEmailIgnoreCase(email);
		
		if(user.isPresent()) {			
			return user.get();
		}
		
		throw new UsernameNotFoundException("User not found");
	}

}
