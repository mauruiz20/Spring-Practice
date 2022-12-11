<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/recursos/estilos/miestilo.css/">

</head>
<body>

Hola ${param.nombreAlumno }. Bienvenido al curso de Spring

<p>
<br>
<h2>Atención a todos</h2>
${mensajeClaro}
</p>

<img alt="foto1" src="${pageContext.request.contextPath}/recursos/imgs/illustration_dashboard.png">

</body>
</html>