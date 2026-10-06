<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entidades.Seguro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Seguros</title>
<style type="text/css">
	header{
		display: flex; 
		justify-content: space-evenly; 
		align-items: center; 
	}
	
</style>
</head>
<body>
<a href="Inicio.jsp"> Inicio</a> <a href="AgregarSeguro.jsp"> Agregar Seguros</a> <a href="<%= request.getContextPath() %>/ListarSeguros"> Listar Seguros</a>

<h1>"Tipo de seguros en la base de datos"</h1>

<form method="get" action="<%= request.getContextPath() %>/ListarSeguros">
    Busqueda por tipo de seguros:
    <select name="ddlTipoSeguro">
        <option value="1">Seguro de casas</option>
        <option value="2">Seguro de vida</option>
        <option value="3">Seguro de motos</option>
    </select>
    <input type="submit" name="btnFiltrar" value="Filtrar">
	<%
	    ArrayList<Seguro> listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaSeguros");
	%>
	
	<table border="1" cellpadding="5">
	    <tr>
	        <th>ID Seguro</th>
	        <th>Descripción Seguro</th>
	        <th>Descripción Tipo Seguro</th>
	        <th>Costo Contratación</th>
	        <th>Costo Máximo Asegurado</th>
	    </tr>
	<%
	    if (listaSeguros != null) {
	        for (Seguro seg : listaSeguros) {
	%>
	    <tr>
	        <td><%= seg.getIdseguro() %></td>
	        <td><%= seg.getDescripcion() %></td>
	        <td><%= seg.getDescripcionTipo() %></td>
	        <td><%= seg.getCostocont() %></td>
	        <td><%= seg.getCostoaseg() %></td>
	    </tr>
	<%
	        }
	    }
	%>
	</table>
</form>

</body>
</html>