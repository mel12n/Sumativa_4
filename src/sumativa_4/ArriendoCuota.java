package sumativa_4;

import java.util.ArrayList;
import java.io.Serializable;


public class ArriendoCuota extends Arriendo implements Serializable{
	
	// atributos
	private int cantidadCuotas;
	private ArrayList<CuotaArriendo> cuotas; // en que casos es Final?
	private static final long serialVersionUID = 1L;

	// constructor
	
	public ArriendoCuota(int pNumArriendo, String pFecArr, int pDiasArriendo, Cliente pCliente, Automovil pAutomovil, int pCantidadCuotas) {
		super(pNumArriendo, pFecArr, pDiasArriendo, pCliente, pAutomovil);
		this.cantidadCuotas = pCantidadCuotas;
	}
		
	// getters
	public int getCantidadCuotas() {
		return this.cantidadCuotas;
	}
	public ArrayList<CuotaArriendo> getCuotas() {
		return this.cuotas;
	}
	
	// setters
	public void setCantidadCuotas(int pCantidadCuotas) throws DatoInvalidoException {
		if (pCantidadCuotas <= 0 || pCantidadCuotas > 6) {
			throw new DatoInvalidoException("Número de cuota inválido. Debe ser entre 1 y 6.");
		}
		this.cantidadCuotas = pCantidadCuotas;
	}
	
	// método toString
	
	@Override
	public String toString() {
		return super.toString() + ", cantidad de cuotas: " + getCantidadCuotas(); 
	}
	
	// métodos customer
	
	public ArrayList<CuotaArriendo> generarCuotas(int precioDia) {
	    this.cuotas = new ArrayList<CuotaArriendo>();
	    int montoArriendo = obtenerMontoApagar(precioDia);
	    int montoCuota = montoArriendo / getCantidadCuotas();
	    for (int i = 0; i < getCantidadCuotas(); i++) {
	        CuotaArriendo cuota = new CuotaArriendo(i + 1, montoCuota);
	        this.cuotas.add(cuota);
	    }
	    return this.cuotas;
	}
	
	public boolean ingresarArriendoConCuota(int precioDia, Cliente clienteAtrib, Automovil automovilAtrib) {
		if (evaluarArriendo(clienteAtrib, automovilAtrib) == true) {
			automovilAtrib.setCondicion('A'); // Cambia la condicion del automovil a Arrendado
			generarCuotas(precioDia); // Revisar
			return true;
		} else {
			return false;
		}
	}
	public void mostrarMensaje(String nMensaje) {
		System.out.println(nMensaje);
	}
}
