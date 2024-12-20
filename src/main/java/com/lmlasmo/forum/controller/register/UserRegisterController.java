package com.lmlasmo.forum.controller.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lmlasmo.forum.dto.generic.JwtDTO;
import com.lmlasmo.forum.dto.generic.UserDTO;
import com.lmlasmo.forum.dto.register.LoginDTO;
import com.lmlasmo.forum.dto.register.SignupDTO;
import com.lmlasmo.forum.service.JwtService;
import com.lmlasmo.forum.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserRegisterController {

	private UserService userService;
	private JwtService jwtService;
	private AuthenticationManager manager;
	private PasswordEncoder encoder;
	
	
	@Autowired
	public UserRegisterController(UserService userService, JwtService jwtService, AuthenticationManager manager, PasswordEncoder encoder) {
		this.userService = userService;
		this.jwtService = jwtService;
		this.manager = manager;
		this.encoder = encoder;	
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDTO> login(@RequestBody @Valid LoginDTO login){
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
		
		Authentication auth = manager.authenticate(authToken);
		
		SecurityContextHolder.getContext().setAuthentication(auth);		
		
		List<String> roles = auth.getAuthorities()
				.stream()
				.map(a -> a.getAuthority())
				.toList();
		
		String token = jwtService.gerateToken(login.getEmail(), roles);
		
		return ResponseEntity.ok(new JwtDTO(token));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<UserDTO> signup(@RequestBody @Valid SignupDTO signup){
		
		String passwordEncoded = encoder.encode(signup.getPassword());
		signup.setPassword(passwordEncoded);
		
		UserDTO user = userService.save(signup);
		
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/user/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN') || principal.id == #id")
	public ResponseEntity<Object> delete(@PathVariable("id") int id){
		
		boolean deleted = userService.deleteById(id);
		
		if(deleted) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.badRequest().build();		
	}
	
}
