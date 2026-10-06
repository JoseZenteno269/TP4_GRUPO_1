<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header{
		display: flex; 
		justify-content: space-evenly; 
		align-items: center; 
	}
	
</style>
</head>
<body>

	<header>
		<a href = "Inicio.jsp"> Inicio</a> 
		<a href = "AgregarSeguro.jsp"> Agregar Seguros</a>
		<a href = "<%= request.getContextPath() %>/ListarSeguros"> Listar Seguros </a>
	</header>
	
	<main>
		<section>
			<h1>Soy la página inicio</h1>
		</section>
	</main>
	
	<footer>
	
	</footer>
</body>
</html>
