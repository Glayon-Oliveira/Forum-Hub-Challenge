package com.lmlasmo.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lmlasmo.forum.model.Responses;

public interface ResponsesRepository extends JpaRepository<Responses, Integer> {

	public Page<Responses> findByTopicId(int id, Pageable pageable);

}
