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

	public boolean AgregarSeguros(Seguro seguro){
		
		String query = "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES (?, ?, ?, ?);";
		Object[] parametros = {seguro.getDescripcion(), seguro.getIdtipo(), seguro.getCostocont(), seguro.getCostoaseg()};
		
		return datos.EjecutarAccion(query, parametros) != 0; 
	}
	
	public ArrayList<Seguro> listarSeguros()
	{
	    String query = "SELECT idSeguro, seguros.descripcion AS descripcionSeguro, seguros.idTipo, "
	                 + "tiposeguros.descripcion AS descripcionTipo, costoContratacion, costoAsegurado "
	                 + "FROM seguros INNER JOIN tiposeguros ON seguros.idTipo = tiposeguros.idTipo;";

	    ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();

	    try(Connection connection = datos.obtenerConexion();
	        PreparedStatement pst = connection.prepareStatement(query);
	        ResultSet rst = pst.executeQuery();){

	        while(rst.next())
	        {
	            Seguro seg = new Seguro();

	            seg.setIdseguro(rst.getInt("idSeguro"));
	            seg.setDescripcion(rst.getString("descripcionSeguro"));
	            seg.setIdtipo(rst.getInt("idTipo"));
	            seg.setDescripcionTipo(rst.getString("descripcionTipo"));
	            seg.setCostocont(rst.getDouble("costoContratacion"));
	            seg.setCostoaseg(rst.getDouble("costoAsegurado"));

	            listaSeguros.add(seg);
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }

	    return listaSeguros;
	}
	
	public ArrayList<Seguro> listarSegurosPorTipo(int idTipo)
	{
	    String query = "SELECT idSeguro, seguros.descripcion AS descripcionSeguro, seguros.idTipo, "
	                 + "tiposeguros.descripcion AS descripcionTipo, costoContratacion, costoAsegurado "
	                 + "FROM seguros INNER JOIN tiposeguros ON seguros.idTipo = tiposeguros.idTipo "
	                 + "WHERE seguros.idTipo = ?;";

	    ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();

	    try(Connection connection = datos.obtenerConexion();
	        PreparedStatement pst = connection.prepareStatement(query);)
	    {
	        pst.setInt(1, idTipo);

	        try(ResultSet rst = pst.executeQuery())
	        {
	            while(rst.next())
	            {
	                Seguro seg = new Seguro();

	                seg.setIdseguro(rst.getInt("idSeguro"));
	                seg.setDescripcion(rst.getString("descripcionSeguro"));
	                seg.setIdtipo(rst.getInt("idTipo"));
	                seg.setDescripcionTipo(rst.getString("descripcionTipo"));
	                seg.setCostocont(rst.getDouble("costoContratacion"));
	                seg.setCostoaseg(rst.getDouble("costoAsegurado"));

	                listaSeguros.add(seg);
	            }
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }

	    return listaSeguros;
	}
	
}
