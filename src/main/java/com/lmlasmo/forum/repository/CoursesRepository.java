package com.lmlasmo.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lmlasmo.forum.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {

	public Page<Courses> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
	public Page<Courses> findByCategoryContainingIgnoreCase(String category, Pageable pageable);
	
	public boolean existsByNameIgnoreCase(String name);
	
}
