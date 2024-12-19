package com.lmlasmo.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmlasmo.forum.dto.generic.ResponseDTO;
import com.lmlasmo.forum.service.ResponseService;

@RestController
@RequestMapping("/response")
public class ResponseController {

	private ResponseService service;
	
	@Autowired
	public ResponseController(ResponseService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> findById(@PathVariable("id") int id){
		
		ResponseDTO response = service.findById(id);
		
		if(response != null) {
			return ResponseEntity.ok(response);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/topic/{id}")
	public ResponseEntity<Page<ResponseDTO>> findByTopic(@PathVariable("id") int id, Pageable pageable){
		
		Page<ResponseDTO> responsePage = service.findByTopic(id, pageable);
		
		return ResponseEntity.ok(responsePage);
	}
	
}
