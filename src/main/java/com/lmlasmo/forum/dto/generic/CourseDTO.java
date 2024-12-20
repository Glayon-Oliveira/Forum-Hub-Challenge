package com.lmlasmo.forum.dto.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmlasmo.forum.model.Courses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CourseDTO {
	
	@JsonProperty(required = false)
	@Size(min = 0, max = 0)
	private int id;
	
	@JsonProperty
	@NotBlank
	private String name;
	
	@JsonProperty
	@NotBlank
	private String category;
	
	public CourseDTO() {}
	
	public CourseDTO(Courses course) {
		this.id = course.getId();
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
	
}
