package com.lmlasmo.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmlasmo.forum.model.Topics;

public interface TopicsRepository extends JpaRepository<Topics, Integer> {

	public List<Topics> findByTitleIgnoreCaseContaining(String charSequency);
	
	public List<Topics> findBySolved(boolean soved);
	
}
