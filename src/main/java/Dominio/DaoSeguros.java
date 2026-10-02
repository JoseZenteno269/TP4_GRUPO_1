package Dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidades.Seguro;

public class DaoSeguros {
	
	Datos datos = new Datos();
	
	public DaoSeguros()
	{
		
	}
	
/// Agregar 

	public boolean AgregarSeguros(Seguro seguro)
	{
		Connection connection = null;
		int filas = 0;
		
		try 
		{
			connection = datos.obtenerConexion();
			String query = "INSERT INTO seguros (descripcion, idTipo,costocont, costoaseg) VALUES (?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(2, seguro.getDescripcion());
			pst.setInt(3, seguro.getIdtipo());
			pst.setDouble(4, seguro.getCostocont());
			pst.setDouble(5, seguro.getCostoaseg());
			
			filas = pst.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally {
			try 
			{
				if(connection !=null)
				{
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return filas != 0;
	}
	
	public ArrayList<Seguro> listarSeguros()
	{
		Connection connection = null;
		
		ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
		
		try 
		{
			connection = datos.obtenerConexion();
			String query = "SELECT idSeguro,seguros.descripcion AS descripcionSeguro, tiposeguros.descripcion AS descripcionTipo, costoContratacion, costoAsegurado FROM seguros INNER JOIN tiposeguros ON seguros.idTipo = tiposeguros.idTipo;";
			PreparedStatement pst = connection.prepareStatement(query);
			
			ResultSet rst = pst.executeQuery();
			
			while(rst.next())
			{
				Seguro seg = new Seguro();
				
				seg.setIdseguro(rst.getInt("isSeguro"));
				seg.setDescripcion(rst.getString("descripcion"));
				seg.setIdtipo(rst.getInt("idTipo"));
				seg.setCostocont(rst.getDouble("costoContratacion"));
				seg.setCostoaseg(rst.getDouble("costoAsegurado"));
				
				listaSeguros.add(seg);
			}	
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			try 
			{
				if(connection !=  null)
				{
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listaSeguros;
		
	}
	
}
