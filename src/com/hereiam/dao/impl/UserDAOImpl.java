package com.hereiam.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hereiam.dao.UserDAO;
import com.hereiam.dbutil.DBManager;
import com.hereiam.entity.User;

public class UserDAOImpl implements UserDAO {
	
	private DBManager dbManager = new DBManager();

	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from user_info where username = ? and password = ?";
		
		ResultSet rs = dbManager.execQuery(sql, username, password);
		
		try{
			if (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt(1));
				user.setUsername(username);
				user.setOccupation(rs.getInt(4));
				
				return user;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			dbManager.closeConnection();
		}
		return null;
	}

	
	
	public boolean updateOccupation(User user, int occupation){
		
		String sql = "update user_info set occupation = occupation + ? where userid = ?";
		
		return dbManager.execUpdate(sql, occupation, user.getUserid()) > 0;
	}
	
	
	
	public boolean insertUser(User user) {

		String sql = "insert into user_info values(null, ?, ?, 0)";
		
		return dbManager.execUpdate(sql, user.getPassword(), user.getUsername(), user.getOccupation()) > 0;
	}
	


}
