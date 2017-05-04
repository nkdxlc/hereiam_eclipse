package com.hereiam.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	private Connection conn;
	private PreparedStatement pstmt; 
	
	public DBManager(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	private void openConnection(){
		
		try{
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hereiam","root","1");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public int execUpdate(String sql, Object... params){
		this.openConnection();
		
		try{
			this.pstmt = this.conn.prepareStatement(sql);
			
			for (int i = 0; i < params.length; i++) {
				this.pstmt.setObject(i+1, params[i]);
			}
			return this.pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
			return -1;
		}finally{
			this.closeConnection();
		}
	}
	
	public ResultSet execQuery(String sql,Object...params){
		this.openConnection();
		
		try{
			this.pstmt = this.conn.prepareStatement(sql);
			
			for (int i = 0; i < params.length; i++) {
				this.pstmt.setObject(i+1, params[i]);
			}
			return this.pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection(){
		
		try{
			if (this.pstmt!=null) {
				this.pstmt.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try {
			if (this.conn!=null) {
				this.pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBManager dbManager = new DBManager();
		String sql = "select * from user";//where score>?";
		ResultSet rs = dbManager.execQuery(sql);
		
		try {
			while(rs.next()){
				System.out.println(rs.getInt(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-" + rs.getInt(4) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			dbManager.closeConnection();
		}
	}
}
