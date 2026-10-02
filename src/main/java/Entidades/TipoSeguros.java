package Entidades;

public class TipoSeguros {
	
	private int idtipo; 
	private String nombre; 
	
	public TipoSeguros() {
		nombre = "Sin definir"; 
	}
	
	public TipoSeguros(String nombre) {
		this.nombre = nombre; 
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Tipo [idtipo=" + idtipo + ", nombre=" + nombre + "]";
	}

}
