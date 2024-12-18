package com.lmlasmo.forum.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lmlasmo.forum.dto.generic.UserDTO;
import com.lmlasmo.forum.dto.register.SignupDTO;
import com.lmlasmo.forum.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserRegisterController {

	private UserService userService;
	
	@Autowired
	public UserRegisterController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<UserDTO> signup(@RequestBody @Valid SignupDTO signup){
		
		UserDTO user = userService.save(signup);
		
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") int id){
		
		boolean deleted = userService.deleteById(id);
		
		if(deleted) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.badRequest().build();		
	}
	
}
