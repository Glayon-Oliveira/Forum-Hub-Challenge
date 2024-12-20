package com.lmlasmo.forum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lmlasmo.forum.dto.generic.CourseDTO;
import com.lmlasmo.forum.model.Courses;
import com.lmlasmo.forum.repository.CoursesRepository;

@Service
public class CourseService {

	private CoursesRepository repository;
	
	@Autowired
	public CourseService(CoursesRepository repository) {
		this.repository = repository;
	}
	
	public CourseDTO save(Courses course) {
		
		course = repository.save(course);
		
		return new CourseDTO(course);
	}
	
	public CourseDTO save(CourseDTO dto) {
		
		Courses course = new Courses(dto);
		
		return save(course);
	}
	
	public boolean delete(Courses course) {
		
		repository.delete(course);
		
		return !repository.existsById(course.getId());
	}
	
	public boolean deleteById(int id) {
		
		repository.deleteById(id);
		
		return !repository.existsById(id);
	}
	
	public CourseDTO findById(int id) {
		
		Optional<Courses> course = repository.findById(id);
		
		if(course.isPresent()) {
			return new CourseDTO(course.get());
		}
		
		return null;
	}
	
	public Page<CourseDTO> findByName(String name, Pageable pageable){
		return repository.findByNameContainingIgnoreCase(name, pageable)
				.map(c -> new CourseDTO(c));				
	}
	
	public Page<CourseDTO> findByCategory(String category, Pageable pageable){
		return repository.findByCategoryContainingIgnoreCase(category, pageable)
				.map(c -> new CourseDTO(c));				
	}
	
	public Page<CourseDTO> findAll(Pageable pageable){
		return repository.findAll(pageable)
				.map(c -> new CourseDTO(c));				
	}
	
	public CoursesRepository getRepository() {
		return this.repository;
	}
	
}
