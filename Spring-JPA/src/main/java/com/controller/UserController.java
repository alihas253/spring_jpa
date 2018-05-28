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
import com.service.UserService;
import com.model.Role;
import com.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/getUsers")
	public String getUsers(ModelMap model) {
		List<User> users =  userService.getAllUsers();
		model.put("users", users);
		return "userList";
	}
	
	@RequestMapping("/addUser")
	public String addUser(ModelMap model) {
		List<Role> roles = roleService.getAllRoles();
		model.put("roles", roles);
		return "form";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestParam String name, @RequestParam String username, 
			@RequestParam boolean enabled, @RequestParam long role) {
		User userInstance = new User();
		userInstance.setName(name);
		userInstance.setUsername(username);
		userInstance.setEnabled(enabled);
		
		Role roleInstance = roleService.getRole(role);
		userInstance.setRole(roleInstance);
		
		userService.save(userInstance);
		return "redirect:/spring-mvc/getUsers";
	}
	

}
