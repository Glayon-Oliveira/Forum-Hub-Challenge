package com.lmlasmo.forum.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lmlasmo.forum.model.Responses;

public interface ResponsesRepository extends JpaRepository<Responses, Integer> {

	public Page<Responses> findByTopicId(int id, Pageable pageable);
	
	public Optional<Responses> findByIdAndAuthorId(int responseId, int userId);
	
	public boolean existsByIdAndAuthorId(int responseId, int userId);
	
	public boolean existsByIdAndTopicId(int responseId, int topicAuthorId);

}
