package com.lmlasmo.forum.model;

import java.util.HashSet;
import java.util.Set;

import com.lmlasmo.forum.dto.generic.CourseDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private String category;
	
	@OneToMany(mappedBy = "course")
	private Set<Topics> topics = new HashSet<>();
	
	public Courses() {}	

	public Courses(CourseDTO course) {
		this.name = course.getName();
		this.category = course.getCategory();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<Topics> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topics> topics) {
		this.topics = topics;
	}
	
}
