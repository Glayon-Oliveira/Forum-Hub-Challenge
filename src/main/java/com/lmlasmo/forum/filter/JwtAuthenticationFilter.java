package com.lmlasmo.forum.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lmlasmo.forum.model.Users;
import com.lmlasmo.forum.repository.UsersRepository;
import com.lmlasmo.forum.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private JwtService jwtService;
	private UsersRepository repository;
	
	@Autowired
	public JwtAuthenticationFilter(JwtService jwtService, UsersRepository repository) {
		this.jwtService = jwtService;
		this.repository = repository;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(request.getRequestURI().contains("/login")) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = getToken(request);		
				
		Optional<Users> user = getUser(token);			
		
		if(user.isEmpty()) {
			filterChain.doFilter(request, response);
			return;
		}
		
		Collection<? extends GrantedAuthority> roles = user.get().getAuthorities();		
		
		Authentication auth = UsernamePasswordAuthenticationToken.authenticated(user.get().getUsername(), null, roles);		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		filterChain.doFilter(request, response);				
	}
	
	protected String getToken(HttpServletRequest request) {
		
		String auth = request.getHeader("Authorization");
		
		if(auth != null) {			
			auth = auth.replace("Bearer ", "");						
		}
		
		return auth;		
	}
	
	protected boolean verifyToken(String token) {
		
		if(token == null) {
			return false;
		}
		
		return jwtService.isTokenValid(token);
	}
	
	protected Optional<Users> getUser(String token){
		
		Optional<Users> user = Optional.ofNullable(null);
		
		if(verifyToken(token)) {
			user = repository.findByEmailIgnoreCase(jwtService.getUsername(token));
		}
		
		if(user.isPresent()) {
			return user;
		}		
		
		return user;
	}
	
}
