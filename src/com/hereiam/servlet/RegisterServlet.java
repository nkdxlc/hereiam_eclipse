package com.hereiam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hereiam.entity.User;
import com.hereiam.service.UserService;
import com.hereiam.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//设置输出内容类型
		response.setContentType("text/html;charset=utf-8");	

		//获取out输出对象---需要输出内容时加此句
		PrintWriter out = response.getWriter();	   	


		//设置字符编码---需要字符转码时加此句
		request.setCharacterEncoding("utf-8"); 
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		
		UserService userService = new UserServiceImpl();
		
		user = userService.register(user);
		
		Gson gson = new Gson();
		
		String userInfo = gson.toJson(user);
		System.out.println("注册请求收到了！");
		
	}

}
