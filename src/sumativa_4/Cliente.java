package sumativa_4;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

	// atributos

	private String cedula;
	private String nombre;
	private Boolean vigencia;
	
	// métodos constructores
	
	public Cliente(String cedula, String nombre ) throws DatoInvalidoException{
			validarCedula(cedula);
			this.cedula = cedula;
			this.nombre = nombre;
			this.vigencia = true;	 	
	}
	
	// setters
	
	public void setCedula(String nCedula) throws DatoInvalidoException{
		validarCedula(nCedula);
		this.cedula = nCedula;	
	}
	public void setNombre(String nNombre) {
		this.nombre = nNombre;
	}
	public void setVigencia(Boolean nVigencia) {
		this.vigencia = nVigencia;
	}
	// getters
	
	public String getCedula() {
		return this.cedula;
	}
	public String getNombre() {
		return this.nombre;
	}
	public Boolean getVigencia() {
		return this.vigencia;
	}
	// toString
	@Override
	public String toString() {
		return "Cliente: [cedula: " + getCedula() + ", nombre: " + getNombre() + ", vigencia: " + getVigencia()+"]";
	}
	// customers
	
	public void deshabilitarCliente() {
		setVigencia(false);
	}
	
	// validaciones
	
	public void validarCedula(String Cedula) throws DatoInvalidoException{
	    if (Cedula.length() != 10) {
	    	throw new DatoInvalidoException("Error en el Rut: La cédula debe tener 10 caracteres. Anteponer un 0 si es necesario.");
	    }
	    for (int i = 0; i < 8; i++) {
	        if (!Character.isDigit(Cedula.charAt(i))) {
	            throw new DatoInvalidoException("Error en el Rut: Los primeros 8 caracteres deben ser numéricos.");
	        }
	    }
	    // Verificar si el carácter en la posición 8 es '-'
	    if (Cedula.charAt(8) != '-') {
	    	throw new DatoInvalidoException("Error en el Rut: Anteponga un guión al digito verficador.");
	    }
	    // Verificar si el carácter en la posición 9 es 'K' o un dígito numérico
	    	char c = Cedula.charAt(9);
	    	if (c != 'K' && !Character.isDigit(c)) {
	    		throw new DatoInvalidoException("Error en el Rut: El digito verificador debe ser un número o 'K'.");
	    	}
	}
	       
}