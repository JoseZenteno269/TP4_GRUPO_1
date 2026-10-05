package Servicio;

import java.util.ArrayList;

import Dominio.DaoSeguros;
import Entidades.Seguro;

public class ServicioSeguros {
	
	DaoSeguros daoSeguros = new DaoSeguros(); 
	
	public ServicioSeguros(){
		
	}
	
	public Boolean agregarSeguros(String descripcion, int idtipo, double precio1, double precio2) {
		
		Seguro seguro = new Seguro(); 
		
		seguro.setDescripcion(descripcion);
		seguro.setIdtipo(idtipo);
		seguro.setCostocont(precio1);
		seguro.setCostoaseg(precio2);
		
		return daoSeguros.AgregarSeguros(seguro);  
	}
	
	public ArrayList<Seguro> obtenerSeguros(){
		return daoSeguros.listarSeguros(); 
	}
}
