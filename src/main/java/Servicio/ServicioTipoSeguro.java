package Servicio;

import java.util.ArrayList;

import Dominio.DaoTipoSeguros;
import Entidades.TipoSeguros;

public class ServicioTipoSeguro {
	
	DaoTipoSeguros daoTipoSeguros = new DaoTipoSeguros(); 
	
	public ServicioTipoSeguro() {
		
	}
	
	public ArrayList<TipoSeguros> obtenerTipoSeguros(){
		return daoTipoSeguros.listarTipoSeguros(); 
	}

}
