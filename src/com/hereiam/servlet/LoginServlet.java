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

public class LoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
				//���������������
				response.setContentType("text/html;charset=utf-8");	

				//��ȡout�������---��Ҫ�������ʱ�Ӵ˾�
				PrintWriter out = response.getWriter();	   	


				//�����ַ�����---��Ҫ�ַ�ת��ʱ�Ӵ˾�
				request.setCharacterEncoding("utf-8"); 
				
				System.out.println("��ӭ���ʷ�����GET����");
				out.println("��ӭ���ʷ�����GET����");
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		response.setContentType("text/html;charset=utf-8");	

	
		PrintWriter out = response.getWriter();	   	

	
	    HttpSession session = request.getSession();	

	
		request.setCharacterEncoding("utf-8"); 	

	
		String username = request.getParameter("username");
		String password = request.getParameter("password");

	
		
		UserService userService = new UserServiceImpl();
		
		
		User user = userService.login(username, password);
		
	
		
		Gson gson = new Gson();
		
		String userInfo = gson.toJson(user);
		System.out.println("Post�����յ��ˣ�");
		
		out.println(userInfo);
		
		out.flush();
	}
}
