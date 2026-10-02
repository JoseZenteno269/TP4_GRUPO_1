<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Seguros</title>
</head>
<body>
<a href = "Inicio.jsp"> Inicio</a> <a href = "AgregarSeguro.jsp"> Agregar Seguros</a> <a href = "ListarSeguros.jsp"> Listar Seguros</a>

		<h1>Agregar Seguros</h1>

		<form method="post" action="">
			<table>
				<tr>
					<td>Id Seguro:</td>
					<td>3</td>
				</tr>
				<tr>
					<td>Descripción:</td>
					<td><input type="text" name="txtDescripcion" required></td>
				</tr>
				<tr>
					<td>Tipo de Seguro:</td>
					<td>
						<select name="ddlTipoSeguro">
							<option value="1">Seguro de casas</option>
							<option value="2">Seguro de vida</option>
							<option value="3">Seguro de motos</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Costo contratación:</td>
					<td><input type="number" step="0.01" name="txtCostoContratacion" required></td>
				</tr>
				<tr>
					<td>Costo Máximo Asegurado:</td>
					<td><input type="number" step="0.01" name="txtCostoMaximo" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="btnAceptar" value="Aceptar"></td>
				</tr>
			</table>
		</form>
	</body>

	</html>