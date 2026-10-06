<%@page import="Servicio.ServicioSeguros"%>
<%@page import="Entidades.Seguro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Seguros</title>
<style type="text/css">
	header{
		display: flex; 
		justify-content: space-evenly; 
		align-items: center; 
	}
	
</style>
</head>
<body>
<a href = "Inicio.jsp"> Inicio</a> <a href = "AgregarSeguro.jsp"> Agregar Seguros</a> <a href = "<%= request.getContextPath() %>/ListarSeguros"> Listar Seguros</a>

		<h1>Agregar Seguros</h1>

		<form method="post" action="<%= request.getContextPath() %>/AgregarSeguro">
			<table>
				<tr> <td>Id Seguro:<td> <%= new ServicioSeguros().ObtenerID() %>
				</tr>
				<tr>
					<td>Descripción:</td>
					<td><input type="text" name="txtDescripcion" maxlength="200" required></td>
				</tr>
				<tr>
					<td>Tipo de Seguro:</td>
					<td>
						<select name="ddlTipoSeguro" required>
							<option value="1">Seguro de casas</option>
							<option value="2">Seguro de vida</option>
							<option value="3">Seguro de motos</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Costo contratación:</td>
					<td><input type="number" min="0" step="0.01" name="txtCostoContratacion" required></td>
				</tr>
				<tr>
					<td>Costo Máximo Asegurado:</td>
					<td><input type="number" min="0" step="0.01" name="txtCostoMaximo" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="btnAceptar" value="Aceptar"></td>
				</tr>
			</table>
		<% if ("1".equals(request.getParameter("agregado"))) { %>
		<p>El seguro se guardó correctamente.</p>
		<% } %>
		<% if (request.getAttribute("errorAgregarSeguro") != null) { %>
		<p>No se pudo guardar el seguro. Revise los datos e inténtelo nuevamente.</p>
		<% } %>
		</form>
	</body>

	</html>
