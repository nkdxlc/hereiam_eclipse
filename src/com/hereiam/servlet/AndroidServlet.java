package com.hereiam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hereiam.entity.User;


public class AndroidServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				//设置输出内容类型
				response.setContentType("text/html;charset=utf-8");	

				//获取out输出对象---需要输出内容时加此句
				PrintWriter out = response.getWriter();	   	


				//设置字符编码---需要字符转码时加此句
				request.setCharacterEncoding("utf-8"); 
				
				//接收数据
				String username = request.getParameter("username");
				
				username = new String(username.getBytes("iso8859-1"),"utf-8");
				System.out.println("欢迎访问服务器GET请求username="+username);
				
				//调用业务方法
				User user = new User();
				
				Gson gson = new Gson();
				
				String userJson = gson.toJson(user);
				
				//out.println("hereiam的Get运行成功！");
				
				out.println(userJson);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//设置输出内容类型
				response.setContentType("text/html;charset=utf-8");	

				//获取out输出对象---需要输出内容时加此句
				PrintWriter out = response.getWriter();	   	


				//设置字符编码---需要字符转码时加此句
				request.setCharacterEncoding("utf-8"); 

				//接收数据
				String username = request.getParameter("username");
				
				username = new String(username.getBytes("iso8859-1"),"utf-8");
				System.out.println("欢迎访问服务区Post请求username="+ username);
				out.println("hereiam的Post运行成功！");
	}

}
