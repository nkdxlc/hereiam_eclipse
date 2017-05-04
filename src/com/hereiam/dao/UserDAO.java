package com.hereiam.dao;
import com.hereiam.entity.User;
public interface UserDAO {

	//根据用户名和密码查找用户
	User findUser(String username, String password);
	
}
