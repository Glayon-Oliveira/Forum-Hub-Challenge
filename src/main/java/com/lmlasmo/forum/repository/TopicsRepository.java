package com.lmlasmo.forum.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lmlasmo.forum.model.Topics;

public interface TopicsRepository extends JpaRepository<Topics, Integer> {

	public Page<Topics> findByTitleIgnoreCaseContaining(String charSequency, Pageable pageable);
	
	public Page<Topics> findBySolved(boolean solved, Pageable pageable);
	
	public Page<Topics> findByCourseId(int id, Pageable pageable);
	
	public Page<Topics> findByCourseIdAndSolved(int id, boolean solved, Pageable pageable);
	
	public Optional<Topics> findByIdAndAuthorId(int topicId, int userId);
	
	public boolean existsByIdAndAuthorId(int topicId, int userId);
	
}
