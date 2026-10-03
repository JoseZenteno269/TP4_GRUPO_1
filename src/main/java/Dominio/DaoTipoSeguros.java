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
		Connection conn = null;
		try {
			conn = datos.obtenerConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select idTipo,descripcion FROM tipoSeguros");

			while (rs.next()) {
				TipoSeguros tipoSeguroRs = new TipoSeguros();
				tipoSeguroRs.setIdtipo(rs.getInt("idTipo"));
				tipoSeguroRs.setNombre(rs.getString("descripcion"));
				listaTipoSeguros.add(tipoSeguroRs);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaTipoSeguros;
	}
}
