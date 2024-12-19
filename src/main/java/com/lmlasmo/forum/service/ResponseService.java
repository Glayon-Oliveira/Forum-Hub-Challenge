package com.lmlasmo.forum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lmlasmo.forum.dto.generic.ResponseDTO;
import com.lmlasmo.forum.dto.register.RResponseDTO;
import com.lmlasmo.forum.model.Responses;
import com.lmlasmo.forum.repository.ResponsesRepository;

@Service
public class ResponseService {

	private ResponsesRepository repository;
	
	@Autowired
	public ResponseService(ResponsesRepository repository) {
		this.repository = repository;
	}
	
	public ResponseDTO save(Responses response) {
		
		repository.save(response);
		
		return new ResponseDTO(response);
	}
	
	public ResponseDTO save(RResponseDTO rResponse) {
		
		Responses response = new Responses(rResponse);
		
		return save(response);
	}
	
	public boolean delete(Responses response) {
		
		repository.delete(response);
		
		return !repository.existsById(response.getId());
	}
	
	public boolean deleteById(int id) {
		
		repository.deleteById(id);
		
		return !repository.existsById(id);
	}
	
	public ResponseDTO setSolved(int id) {
		
		Optional<Responses> responseOp = repository.findById(id);
		
		if(responseOp.isPresent()) {
			
			Responses response = responseOp.get();
			response.setSolution(true);
			
			return save(response);
		}
		
		return null;
	}
	
	public ResponseDTO findById(int id) {
		
		Optional<Responses> response = repository.findById(id);
		
		if(response.isPresent()) {
			return new ResponseDTO(response.get());
		}
		
		return null;
	}
	
	public Page<ResponseDTO> findByTopic(int id, Pageable pageable){
		return repository.findByTopicId(id, pageable)
				.map(r -> new ResponseDTO(r));
	}	
	
	public ResponsesRepository getRepository() {
		return this.repository;
	}
	
}
