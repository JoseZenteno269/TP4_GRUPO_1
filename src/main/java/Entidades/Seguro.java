package Entidades;

public class Seguro {
	
	private int idseguro; 
	private String descripcion; 
	private int idtipo; 
	private double costocont; 
	private double costoaseg; 
	private String descripcionTipo;
	private static int cont = 0; 
	
	public Seguro() {
		cont++; 
		idseguro = cont; 
		idseguro = 0; 
		descripcion = "Sin definir"; 
		idtipo = 0; 
		costocont = 0; 
		costoaseg = 0; 
	}
	
	public Seguro(int idseguro ,String descripcion, int idtipo, double costo1, double costo2) {
		cont++; 
		this.idseguro = cont; 
		this.idseguro = idseguro; 
		this.descripcion = descripcion; 
		this.idtipo = idtipo; 
		this.costocont = costo1; 
		this.costoaseg = costo2; 
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public double getCostocont() {
		return costocont;
	}

	public void setCostocont(double costocont) {
		this.costocont = costocont;
	}

	public double getCostoaseg() {
		return costoaseg;
	}

	public void setCostoaseg(double costoaseg) {
		this.costoaseg = costoaseg;
	}

	public int getIdseguro() {
		return idseguro;
	}
	
	public void setIdseguro(int idseguro) {
		this.idseguro = idseguro; 
	}

	public String getDescripcionTipo() {
		return descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

	@Override
	public String toString() {
		return "Seguro [idseguro=" + idseguro + ", descripcion=" + descripcion + ", idtipo=" + idtipo + ", costocont="
				+ costocont + ", costoaseg=" + costoaseg + ", descripcionTipo=" + descripcionTipo + "]";
	}

}
