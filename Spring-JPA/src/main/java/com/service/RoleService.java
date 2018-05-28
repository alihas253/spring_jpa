package com.service;

import java.util.List;
import com.model.Role;

public interface RoleService {
	
	List<Role> getAllRoles();
	Role save(Role role);
	Role getRole(long role);

}
