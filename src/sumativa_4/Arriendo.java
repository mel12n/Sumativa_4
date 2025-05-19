package sumativa_4;
import java.io.Serializable;
public class Arriendo implements Serializable{
	 private static final long serialVersionUID = 1L;
	 
	// Atributos
	private int numArriendo;
	private String fechaArriendo; 
	private int diasArriendo;
	private Cliente cliente; 
	private Automovil automovil; 
		
	// Constructor
	public Arriendo(int pNumArriendo, String pFechaArriendo, int pDiasArriendo, Cliente pCliente, Automovil pAutomovil) {
		this.numArriendo = pNumArriendo;
		this.fechaArriendo = pFechaArriendo;
		this.diasArriendo = pDiasArriendo; 
		this.cliente = pCliente;
		this.automovil = pAutomovil;
	}
	
	// Setters
	public void setNumArriendo(int pNumArriendo) {
		this.numArriendo = pNumArriendo;
	}
	public void setFecArr(String pFechaArriendo) {
		this.fechaArriendo = pFechaArriendo;
	}
	public void setDiasArriendo(int pDiasArriendo) {
		this.diasArriendo = pDiasArriendo;
	}
	public void setCliente(Cliente pCliente) {
		this.cliente = pCliente;
	}
	public void setAutomovil(Automovil pAutomovil) {
		this.automovil = pAutomovil;
	}
		
	// Getters
	public int getNumArriendo() {
		return this.numArriendo;
	}
	public String getFechaArriendo() {
		return this.fechaArriendo;
	}
	public int getDiasArriendo() {
		return this.diasArriendo;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	public Automovil getAutomovil() {
		return this.automovil;
	}

	// Método toString
	@Override
	public String toString() {
		return "Arriendo [número:" + getNumArriendo() + ", fecha:" + getFechaArriendo() + ", dias de arriendo:" + getDiasArriendo() + ", cliente: " + cliente.getCedula() + ", automovil: " + automovil.getPatente() + "]";
	}
	
	// Métodos customer
	public int obtenerMontoApagar(int precioDia) { // recibe el precio dia desde la interfaz
		int montoApagar = precioDia * getDiasArriendo();
		return montoApagar;
	}
	
	public boolean evaluarArriendo(Cliente clienteAtrib, Automovil automovilAtrib) { // Agregar atributos de la clase cliente y automovil para validar el arriendo
		
		if (clienteAtrib.getVigencia() == true && automovilAtrib.getCondicion() == 'D') {
			return true;
		} 
		return false;
	} 
	
	public void mostrarMensaje(String nMensaje) {
		System.out.println(nMensaje);
	}
		
}
