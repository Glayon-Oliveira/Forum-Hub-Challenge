package com.lmlasmo.forum.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lmlasmo.forum.dto.generic.TopicDTO;
import com.lmlasmo.forum.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {

	private TopicService service;
	
	public TopicController(TopicService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TopicDTO> findById(@PathVariable("id") int id){
		
		TopicDTO topic = service.findById(id);
		
		if(topic != null) {
			return ResponseEntity.ok(topic);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(params = "title")
	public ResponseEntity<Page<TopicDTO>> findByCourse(@RequestParam String title, Pageable pageable){
		
		Page<TopicDTO> topicPage = service.findByTitle(title, pageable);
		
		return ResponseEntity.ok(topicPage);				
	}
	
	@GetMapping(params = "course")
	public ResponseEntity<Page<TopicDTO>> findByCourse(@RequestParam("id") int id, Pageable pageable){
		
		Page<TopicDTO> topicPage = service.findByCourse(id, pageable);
		
		return ResponseEntity.ok(topicPage);				
	}	
	
	@GetMapping(params = {"course","solved"})
	public ResponseEntity<Page<TopicDTO>> findByCourseAndSolved(@RequestParam("id") int id, @RequestParam("solved") boolean solved, Pageable pageable){
		
		Page<TopicDTO> topicPage = service.findByCourseAndSolved(id, solved, pageable);
		
		return ResponseEntity.ok(topicPage);				
	}
	
	@GetMapping(params = "solved")
	public ResponseEntity<Page<TopicDTO>> findBySolved(@RequestParam("solved") boolean solved, Pageable pageable){
		
		Page<TopicDTO> topicPage = service.findBySolved(solved, pageable);
		
		return ResponseEntity.ok(topicPage);		
	}
	
	@GetMapping
	public ResponseEntity<Page<TopicDTO>> findAll(Pageable pageable){
		
		Page<TopicDTO> topicPage = service.findAll(pageable);
		
		return ResponseEntity.ok(topicPage);		
	}
	
}
