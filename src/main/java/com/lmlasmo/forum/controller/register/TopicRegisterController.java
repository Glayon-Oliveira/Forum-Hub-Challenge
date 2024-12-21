package com.lmlasmo.forum.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmlasmo.forum.dto.generic.TopicDTO;
import com.lmlasmo.forum.dto.register.RTopicDTO;
import com.lmlasmo.forum.model.Users;
import com.lmlasmo.forum.service.TopicService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topic")
public class TopicRegisterController {

	private TopicService service;

	@Autowired
	public TopicRegisterController(TopicService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<TopicDTO> register(@RequestBody @Valid RTopicDTO dto) {

		Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		dto.setAuthor(user.getId());

		TopicDTO topic = service.save(dto);

		return ResponseEntity.ok(topic);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('USER_ADMIN') || @authUser.existsTopic(#id)")
	public ResponseEntity<Object> delete(@PathVariable("id") int id) {

		boolean deleted = service.deleteById(id);

		if (deleted) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.badRequest().build();
	}

}
