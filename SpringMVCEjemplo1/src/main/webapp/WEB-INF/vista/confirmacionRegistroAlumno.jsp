<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmación de Registro</title>
</head>
<body>

	El alumno <strong>${elAlumno.nombre}</strong>, <strong>${elAlumno.apellido}</strong> y edad <strong>${elAlumno.edad}</strong> se ha registrado con éxito.<br>
	Email: <strong>${elAlumno.email}</strong><br>
	Código postal: <strong>${elAlumno.codigoPostal}</strong><br>
	La asignatura escogida es: <strong>${elAlumno.optativa}</strong><br>
	Ciudad de estudios es: <strong>${elAlumno.ciudadEstudios}</strong>
	Idiomas escogidos: <strong>${elAlumno.idiomas}</strong>
</body>
</html>