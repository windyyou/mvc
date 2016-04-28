<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑用户信息</title>
</head>
<body>
	<h1>编辑用户</h1>
	<form action="${pageContext.request.contextPath}/user/updateUser.action" name="userForm" method="post">
		<input type="hidden" name="id" value="${user.id }">
		姓名：<input type="text" name="username" value="${user.username }">
		年龄：<input type="text" name="password" value="${user.password }">
		<input type="submit" value="编辑" >
	</form>
</body>
</html>