package com.lmlasmo.forum.infra.security.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.lmlasmo.forum.model.Responses;
import com.lmlasmo.forum.model.RoleType;
import com.lmlasmo.forum.model.Topics;
import com.lmlasmo.forum.model.Users;
import com.lmlasmo.forum.repository.ResponsesRepository;
import com.lmlasmo.forum.repository.TopicsRepository;

@Component
public class AuthUser {
		
	private TopicsRepository topicsRepository;
	private ResponsesRepository responsesRepository;
		
	@Autowired
	public AuthUser(TopicsRepository topicsRepository, ResponsesRepository responsesRepository) {		
		this.topicsRepository = topicsRepository;
		this.responsesRepository = responsesRepository;		
	}	
	
	public int getId() {
		return getUser().getId();
	}	

	public String getUsername() {
		return getUser().getUsername();
	}	

	public String getEmail() {
		return getUser().getEmail();
	}	

	public String getProfileName() {
		return getUser().getProfile().getName();
	}

	public RoleType getRole() {
		return getUser().getRole().getRole();
	}	
	
	public Optional<Responses> findResponse(int id) {
		return responsesRepository.findByIdAndAuthorId(id, getUser().getId());
	}
		
	public boolean existsResponse(int id) {		
		return responsesRepository.existsByIdAndAuthorId(id, getUser().getId());
	}
	
	public boolean isSubordinateResponse(int id) {
		return responsesRepository.existsByIdAndTopicId(id, getUser().getId());
	}
	
	public Optional<Topics> findTopic(int id) {
		return topicsRepository.findByIdAndAuthorId(id, getUser().getId());
	}
		
	public boolean existsTopic(int id) {		
		return topicsRepository.existsByIdAndAuthorId(id, getUser().getId());
	}
	
	public boolean isLoaded() {
		return (getUser() != null);
	}
	
	public Users getUser() {
		return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public TopicsRepository getTopicsRepository() {
		return topicsRepository;
	}

	public ResponsesRepository getResponsesRepository() {
		return responsesRepository;
	}	
	
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
}
