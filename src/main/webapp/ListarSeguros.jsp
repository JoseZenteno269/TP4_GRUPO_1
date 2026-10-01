<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Seguros</title>
</head>
<body>
<a href="Inicio.jsp"> Inicio</a> <a href="AgregarSeguro.jsp"> Agregar Seguros</a> <a href="ListarSeguros.jsp"> Listar Seguros</a>

<h1>"Tipo de seguros en la base de datos"</h1>

<form method="get" action="">
    Busqueda por tipo de seguros:
    <select name="ddlTipoSeguro">
        <option value="1">Seguro de casas</option>
        <option value="2">Seguro de vida</option>
        <option value="3">Seguro de motos</option>
    </select>
    <input type="submit" name="btnFiltrar" value="Filtrar">
</form>

<table border="1" cellpadding="5">
    <tr>
        <th>ID Seguro</th>
        <th>Descripción Seguro</th>
        <th>Descripción Tipo Seguro</th>
        <th>Costo Contratación</th>
        <th>Costo Máximo Asegurado</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Es un seguro de salud para intervenciones quirúrgicas de alta complejidad, a un costo accesible.</td>
        <td>Seguro de casas</td>
        <td>600.0</td>
        <td>15000.0</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Asegura toda la gama de motocicletas de uso particular, desde motos y ciclomotores hasta deportivas: street, custom, enduro, scooter y choperas, entre otras.</td>
        <td>Seguro de motos</td>
        <td>1200.0</td>
        <td>28000.0</td>
    </tr>
</table>
<a href="Inicio.jsp"> Inicio</a>
</body>
</html>