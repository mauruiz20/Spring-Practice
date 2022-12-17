<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
</head>
<body>

<h1>Lista de clientes</h1>

<table>
	<tr>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Email</th>
		<th>Acciones</th>
	</tr>
	<c:forEach var="clienteTemp" items="${clientes}">
	
		<c:url var="linkEditar" value="/cliente/muestraFormularioEditar">
			
			<c:param name="clienteId" value="${clienteTemp.id}"/>
			
		</c:url>
		
		<c:url var="linkBorrar" value="/cliente/borrar">
			
			<c:param name="clienteId" value="${clienteTemp.id}"/>
			
		</c:url>
	
		<tr>
			<td>${clienteTemp.nombre}</td>
			<td>${clienteTemp.apellido}</td>
			<td>${clienteTemp.email}</td>
			<td>
				<a href="${linkEditar}"><input type="button" value="E" /></a>
				<a href="${linkBorrar}"><input type="button" value="B" onclick="if (!(confirm('Confirma borrar?'))) return false"/></a>
			</td>
		</tr>
	</c:forEach>
</table>

<br />

<input type="button" value="Agregar Cliente" onclick="window.location.href='muestraFormularioAgregar'; return false;" />

</body>
</html>