<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenido</h1>
	<hr />
	<h3>Hemos llegado</h3>
	
	<p>
		Usuario: <security:authentication property="principal.username"/>
		<br />
		<br />
		Rol: <security:authentication property="principal.authorities"/>
	</p>
	
	<form:form action="${pageContext.request.contextPath}/logout" methos="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
</body>
</html>