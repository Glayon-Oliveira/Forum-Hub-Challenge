package com.lmlasmo.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmlasmo.forum.model.RoleType;
import com.lmlasmo.forum.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer>{

	public Roles findByRole(RoleType role);
	
}
