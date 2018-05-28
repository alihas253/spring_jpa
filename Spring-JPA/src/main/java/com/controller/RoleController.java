package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.RoleService;

import com.model.Role;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/getRoles")
	public String getRoles(ModelMap model) {
		List<Role> roles =  roleService.getAllRoles();
		model.put("roles", roles);
		return "roleList";
	}
	
	@RequestMapping("/addRole")
	public String addRole() {
		return "formRole";
	}
	
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public String saveRole(@RequestParam String name) {
		Role roleInstance = new Role();
		roleInstance.setName(name);
		
		roleService.save(roleInstance);
		return "redirect:/spring-mvc/getRoles";
	}
	

}
