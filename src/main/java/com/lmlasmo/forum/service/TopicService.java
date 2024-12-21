package com.lmlasmo.forum.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lmlasmo.forum.dto.generic.TopicDTO;
import com.lmlasmo.forum.dto.register.RTopicDTO;
import com.lmlasmo.forum.dto.register.UTopicDTO;
import com.lmlasmo.forum.model.Topics;
import com.lmlasmo.forum.repository.TopicsRepository;

import jakarta.validation.Valid;

@Service
public class TopicService {

	private TopicsRepository repository;
	
	public TopicService(TopicsRepository repository) {
		this.repository = repository;
	}
	
	public TopicDTO save(Topics topic) {
		
		repository.save(topic);
		
		return new TopicDTO(topic, topic.getResponses().size());
	}
	
	public TopicDTO save(RTopicDTO rTopic) {
		
		Topics topic = new Topics(rTopic);
				
		return save(topic);
	}
	
	public TopicDTO update(int id, UTopicDTO uTopic){
	
		Optional<Topics> topicOp = repository.findById(id);
		
		if(topicOp.isPresent()){
			
			Topics topic = topicOp.get();
			
			String uTitle = uTopic.getTitle();
			String uMessage = uTopic.getMessage();
			
			if(!uTitle.isEmpty() && topic.getTitle().equals(uTitle)){
			
				topic.setTitle(title);
				
			}else if(!uMessage.isEmpty() && topic.getMessage().equals(uMessage)){
			
				topic.setTitle(uTopic.getMessage());
				
			}else{
				return new TopicDTO();
			}
			
			return save(topic);	
		}
	
		return null;	
	}
	
	public boolean delete(Topics topic) {
		
		repository.delete(topic);
		
		return !repository.existsById(topic.getId());
	}
	
	public boolean deleteById(int id) {
		
		repository.deleteById(id);
		
		return !repository.existsById(id);
	}
	
	public TopicDTO findById(int id) {
		
		Optional<Topics> topic = repository.findById(id);
		
		if(topic.isPresent()) {
			return new TopicDTO(topic.get(), topic.get().getResponses().size());
		}
		
		return null;
	}
	
	public Page<TopicDTO> findByTitle(String title, Pageable pageable){
		return repository.findByTitleIgnoreCaseContaining(title, pageable)		
				.map(t -> new TopicDTO(t, t.getResponses().size()));
	}
	
	public Page<TopicDTO> findByCourse(int id, Pageable pageable){
		return repository.findByCourseId(id, pageable)		
				.map(t -> new TopicDTO(t, t.getResponses().size()));
	}
	
	public Page<TopicDTO> findByCourseAndSolved(int id, boolean solved, Pageable pageable){
		return repository.findByCourseIdAndSolved(id, solved, pageable)		
				.map(t -> new TopicDTO(t, t.getResponses().size()));
	}
	
	public Page<TopicDTO> findBySolved(boolean solved, Pageable pageable){
		return repository.findBySolved(solved, pageable)		
				.map(t -> new TopicDTO(t, t.getResponses().size()));
	}
	
	public Page<TopicDTO> findAll(Pageable pageable){
		return repository.findAll(pageable)		
				.map(t -> new TopicDTO(t, t.getResponses().size()));
	}
	
	public TopicsRepository getRepository() {
		return this.repository;
	}	
	
}
