<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UserLoginServlet" method="post">
	用户名<input type="text" name="username" value="user1"/><br/>
	密码<input type="password" name="password" value="1"/><br/>
	<input type="submit" value="提交"/>
	<input type="button" value="新用户注册" onclick="location='user_register.jsp'">
</form>
</body>
</html>