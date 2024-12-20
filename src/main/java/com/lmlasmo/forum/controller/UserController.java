package com.lmlasmo.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lmlasmo.forum.dto.generic.ProfileDTO;
import com.lmlasmo.forum.dto.generic.UserDTO;
import com.lmlasmo.forum.infra.security.util.AuthUser;
import com.lmlasmo.forum.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<UserDTO> findUserAuthenticated(AuthUser user){				
		
		return ResponseEntity.ok(new UserDTO(user.getUser()));		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProfileDTO> findById(@PathVariable("id") int id){	
		
		ProfileDTO profile = userService.findById(id);
		
		if(profile != null) {
			return ResponseEntity.ok(profile);
		}
		
		return ResponseEntity.notFound().build();
	}	
	
	@GetMapping(params = "ids")
	public ResponseEntity<List<ProfileDTO>> findByIds(@RequestParam("ids") Integer[] ids){		
		
		List<ProfileDTO> profiles = userService.findAllById(ids).stream()
				.map(u -> (ProfileDTO) u)
				.toList();
		
		return ResponseEntity.ok(profiles);
	}
	
}
