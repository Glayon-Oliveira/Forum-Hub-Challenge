package com.lmlasmo.forum.model;

import java.util.List;
import java.util.stream.Collectors;

public enum RoleType {

	USER_COMUM(1),
	USER_SUBADMIN(2),
	USER_ADMIN(3);
	
	private int weight;
	
	private RoleType(int weight){
		this.weight = weight;
	}
	
	public int getWeitht() {
		return this.weight;
	}
	
	public List<RoleType> getHierarchyBy() {
		
		RoleType type = RoleType.valueOf(this.name());
		
		List<RoleType> hierarchy = List.of(RoleType.values())
				.stream()
				.filter(r -> r.weight < type.getWeitht() || r.equals(type))
				.collect(Collectors.toList());		
				
		return hierarchy;
	}
	
}
