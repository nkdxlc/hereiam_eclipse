package com.hereiam.dao;
import com.hereiam.entity.User;
public interface UserDAO {

	//�����û�������������û�
	User findUser(String username, String password);
	
}
