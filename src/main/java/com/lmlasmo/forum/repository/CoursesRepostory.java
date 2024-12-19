package com.lmlasmo.forum.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmlasmo.forum.model.Courses;

public interface CoursesRepostory extends JpaRepository<Courses, Integer> {

	public Optional<Courses> findByNameIgnoreCase(String name);
	
	public List<Courses> findByCategoryIgnoreCase(String category);
	
	public boolean existsByNameIgnoreCase(String name);
	
}
