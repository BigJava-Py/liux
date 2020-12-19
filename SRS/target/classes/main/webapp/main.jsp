<%@page import="vo.User"%>
<%@page import="java.util.ArrayList"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
	<%
		//User user=(User)session.getAttribute("user");
		// System.out.println("用户名"+user.getName());
		/*
		User user=(User)session.getAttribute("user");
		//String cp = request.getContextPath();
		if(user.getName()==null){
			request.setAttribute("errors", "你必须登录后才能访问该资源");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		*/
	%>

</head>
<body>
	
	欢迎您：
	${user.name}
	<br/><br/>
	
	<strong>首页 |<a href="courseQuery.jsp">课程查询</a> | <a href="courseQuery.jsp">选课中心</a> | 
	<a href="courseQuery.jsp">成绩查询</a> | <a href="user.jsp">个人中心</a> | <a href="login.html">安全退出</a> </strong>
	<div>
    <img src="image/2024248.jpg" style="width:100%;height: 100%;"/>
    </div>

</body>
</html>