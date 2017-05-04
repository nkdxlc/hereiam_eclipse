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
				
				//���������������
				response.setContentType("text/html;charset=utf-8");	

				//��ȡout�������---��Ҫ�������ʱ�Ӵ˾�
				PrintWriter out = response.getWriter();	   	


				//�����ַ�����---��Ҫ�ַ�ת��ʱ�Ӵ˾�
				request.setCharacterEncoding("utf-8"); 
				
				//��������
				String username = request.getParameter("username");
				
				username = new String(username.getBytes("iso8859-1"),"utf-8");
				System.out.println("��ӭ���ʷ�����GET����username="+username);
				
				//����ҵ�񷽷�
				User user = new User();
				
				Gson gson = new Gson();
				
				String userJson = gson.toJson(user);
				
				//out.println("hereiam��Get���гɹ���");
				
				out.println(userJson);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//���������������
				response.setContentType("text/html;charset=utf-8");	

				//��ȡout�������---��Ҫ�������ʱ�Ӵ˾�
				PrintWriter out = response.getWriter();	   	


				//�����ַ�����---��Ҫ�ַ�ת��ʱ�Ӵ˾�
				request.setCharacterEncoding("utf-8"); 

				//��������
				String username = request.getParameter("username");
				
				username = new String(username.getBytes("iso8859-1"),"utf-8");
				System.out.println("��ӭ���ʷ�����Post����username="+ username);
				out.println("hereiam��Post���гɹ���");
	}

}
