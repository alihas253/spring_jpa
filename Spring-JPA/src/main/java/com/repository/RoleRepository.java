package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Role;

public interface RoleRepository {
	
	public Role save(Role role);
	public List<Role> getAll();
	public Role getRole(long role);
	
}
