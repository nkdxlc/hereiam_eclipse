package com.hereiam.service;

import java.util.List;

import com.hereiam.entity.User;

public interface UserService {

	//�û���¼
	User login(String username, String password);
	
	User register(User user);
	
	List<User> getUserList(String username, String occupation); 
}
