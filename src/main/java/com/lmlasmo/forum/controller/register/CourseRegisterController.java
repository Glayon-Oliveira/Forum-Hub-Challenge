package com.lmlasmo.forum.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmlasmo.forum.dto.generic.CourseDTO;
import com.lmlasmo.forum.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseRegisterController {

	private CourseService courseService;
	
	@Autowired
	public CourseRegisterController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('USER_ADMIN')")
	public ResponseEntity<CourseDTO> register(@RequestBody @Valid CourseDTO course){
		
		course = courseService.save(course);
		
		return ResponseEntity.ok(course);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('USER_ADMIN')")
	public ResponseEntity<Object> delete(int id){
		
		boolean deleted = courseService.deleteById(id);
		
		if(deleted) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.badRequest().build();
	}
	
}
