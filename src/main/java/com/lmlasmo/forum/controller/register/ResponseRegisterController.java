package com.lmlasmo.forum.controller.register;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmlasmo.forum.dto.generic.ResponseDTO;
import com.lmlasmo.forum.dto.register.RResponseDTO;
import com.lmlasmo.forum.service.ResponseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/response")
public class ResponseRegisterController {

	private ResponseService service;	

	public ResponseRegisterController(ResponseService service) {
		this.service = service;		
	}

	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> register(@RequestBody @Valid RResponseDTO dto) {

		ResponseDTO response = service.save(dto);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('USER_ADMIN') || @authUser.isSubordinateResponse(#id) || @authUser.existsResponse(#id)")
	public ResponseEntity<Object> delete(@PathVariable("id") int id) {

		boolean deleted = service.deleteById(id);

		if (deleted) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/solved/set/{id}")
	@PreAuthorize("hasAuthority('USER_ADMIN') || @authUser.isSubordinateResponse(#id)")	
	public ResponseEntity<ResponseDTO> setSolved(@PathVariable("id") int id) {

		ResponseDTO response = service.setSolved(id);

		if (response != null) {
			return ResponseEntity.ok(response);
		}

		return ResponseEntity.notFound().build();
	}

}
