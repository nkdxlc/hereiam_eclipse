package com.hereiam.service.impl;

import java.util.List;

import com.hereiam.dao.UserDAO;
import com.hereiam.dao.impl.UserDAOImpl;
import com.hereiam.entity.User;
import com.hereiam.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAOImpl();
	public User login(String username, String password) {

		User user = userDAO.findUser(username, password);
		
		return user;
	}

	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserList(String username, String occupation) {
		// TODO Auto-generated method stub
		return null;
	}

}
