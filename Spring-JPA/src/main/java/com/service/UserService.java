package com.service;

import java.util.List;
import com.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User save(User user);

}
