package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Role;
import com.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	
	public List<Role> getAllRoles(){
		List roles = roleRepository.getAll();
			
		return roles;
	}
	
	public Role getRole(long role) {
		return roleRepository.getRole(role);
	}

}
