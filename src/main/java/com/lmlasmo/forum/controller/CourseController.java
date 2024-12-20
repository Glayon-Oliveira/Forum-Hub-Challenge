package com.lmlasmo.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmlasmo.forum.dto.generic.CourseDTO;
import com.lmlasmo.forum.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	private CourseService courseService;
	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseDTO> findById(@PathVariable("id") int id){
		
		CourseDTO course = courseService.findById(id);
		
		if(course != null) {
			return ResponseEntity.ok(course);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(params = {"name"})
	public ResponseEntity<Page<CourseDTO>> findByName(String name, Pageable pageable){
		
		Page<CourseDTO> coursePage = courseService.findByName(name, pageable);
		
		return ResponseEntity.ok(coursePage);		
	}
	
	@GetMapping(params = {"category"})
	public ResponseEntity<Page<CourseDTO>> findByCategory(String category, Pageable pageable){
		
		Page<CourseDTO> coursePage = courseService.findByCategory(category, pageable);
		
		return ResponseEntity.ok(coursePage);		
	}
	
	@GetMapping
	public ResponseEntity<Page<CourseDTO>> findAll(Pageable pageable){
		
		Page<CourseDTO> coursePage = courseService.findAll(pageable);
		
		return ResponseEntity.ok(coursePage);		
	}
	
}
