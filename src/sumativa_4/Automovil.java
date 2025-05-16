package sumativa_4;

public class Automovil {

	
	// atributos
	
	private String patente;
	private String marca;
	private String modelo;
	private int anio;
	private char condicion;
	
	// métodos constructores
	
	public Automovil(String patente, String marca, String modelo, int anio) throws DatoInvalidoException{
		if (validarPatente(patente) == false) {
			throw new DatoInvalidoException("La Patente no cumple con el formato (Largo 8)");
		}
		this.patente = patente.toUpperCase();
		this.anio = anio;
		this.marca = marca.toUpperCase();
		this.modelo = modelo.toUpperCase();
		this.condicion = 'D';	
	}
		
	// setters
	
	public void setPatente(String nPatente) throws DatoInvalidoException{
		if (validarPatente(patente) == false) {
			throw new DatoInvalidoException("La Patente no cumple con el formato (Largo 8)");
		}
		this.patente = nPatente.toUpperCase();
	}
	public void setMarca(String nMarca) {
		this.marca = nMarca.toUpperCase();
	}
	public void setModelo(String nModelo) {
		this.modelo = nModelo.toUpperCase();
	}
	public void setAnio(int nAnio) {
		 this.anio = nAnio;
	}
	public void setCondicion(char nCondicion) {
		if (validarCondicion(nCondicion) == true) {
			this.condicion = nCondicion;
		} 
	}
	
	// getters
		
	public String getPatente() {
		return this.patente;
	}
	public String getMarca() {
		return this.marca;
	}
	public String getModelo() {
		return this.modelo;
	}
	public int getAnio() {
		return this.anio;
	}
	public char getCondicion() {
		return this.condicion;
	}
	
	// toString
	@Override
	public String toString() {
		return "Automovil: [Patente: " + getPatente() + ", Marca: " + getMarca() + ", Modelo: " + getModelo() + 
				", Año: " + getAnio() + ", Condición: " + getCondicion() +"]"; 	
	}
	
	// customers
	public boolean asignarArriendo() {
	if (getCondicion() == 'A') {
		return false;
	}
	setCondicion('A');
	return true;	
	}
	
	// validaciones
	
	public boolean validarPatente(String Patente) {
		if (Patente.length() != 8) {
			return false;
		}
		return true;
		
	}
	
	public boolean validarCondicion(char condicion) {
		
		if (condicion == 'D' || condicion == 'A' || condicion == 'M') {
			return true;
		} else {
			return false;
		}
	}
		
}
