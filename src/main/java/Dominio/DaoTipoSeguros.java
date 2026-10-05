package Dominio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.TipoSeguros;

public class DaoTipoSeguros {

	Datos datos = new Datos();

	public ArrayList<TipoSeguros> listarTipoSeguros() {
		
		ArrayList<TipoSeguros> listaTipoSeguros = new ArrayList<TipoSeguros>();
		
		try(Connection cn = datos.obtenerConexion(); 
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT idTipo,descripcion FROM tipoSeguros");){
			
			while (rs.next()) {
				TipoSeguros tipoSeguroRs = new TipoSeguros();
				tipoSeguroRs.setIdtipo(rs.getInt("idTipo"));
				tipoSeguroRs.setNombre(rs.getString("descripcion"));
				listaTipoSeguros.add(tipoSeguroRs);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return listaTipoSeguros;
	}
}
