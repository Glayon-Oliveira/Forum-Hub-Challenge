package com.lmlasmo.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmlasmo.forum.model.Profiles;

public interface ProfilesRepository extends JpaRepository<Profiles, Integer> {

	public List<Profiles> findByNameIgnoreCaseContaining(String charSequency);
	
}
