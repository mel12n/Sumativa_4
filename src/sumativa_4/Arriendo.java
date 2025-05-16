package sumativa_4;

public class Arriendo {
	
	// Atributos
	private int numArriendo;
	private String fecArr; // fecha de arriendo
	private int diasArriendo;
	private int precioDia;
	
	// Constructor
	public Arriendo(int pNumArriendo, String pFecArr, int pDiasArriendo, int pPrecioDia) {
		this.numArriendo = pNumArriendo;
		this.fecArr = pFecArr;
		this.diasArriendo = pDiasArriendo;
		this.precioDia = pPrecioDia ; 
	}
	
	// Getters
	public int getNumArriendo() {
		return numArriendo;
	}
	public String getFecArr() {
		return fecArr;
	}
	public int getDiasArriendo() {
		return diasArriendo;
	}
	public int getPrecioDia() {
		return precioDia;
	}
	
	// Setters
	public void setNumArriendo(int pNumArriendo) {
		this.numArriendo = pNumArriendo;
	}
	public void setFecArr(String pFecArr) {
		this.fecArr = pFecArr;
	}
	public void setDiasArriendo(int pDiasArriendo) {
		this.diasArriendo = pDiasArriendo;
	}
	public void setPrecioDia(int pPrecioDia) {
		this.precioDia = pPrecioDia;
	}
	
	// Método toString
	@Override
	public String toString() {
		return "Arriendo [número:" + numArriendo + ", fecha:" + fecArr + ", dias de arriendo:" + diasArriendo + "]";
	}
	
	// Métodos customer
	public int obtenerMontoApagar() { //revisar
		int montoApagar = getPrecioDia() * getDiasArriendo();
		return montoApagar;
	}
	
	public boolean evaluarArriendo(Cliente clienteAtrib, Automovil automovilAtrib) {
		if (clienteAtrib.getVigencia() == true && automovilAtrib.getCondicion() == 'D') {
			return true;
		} 
		return false;
	} // Agregar atributos de la clase cliente y automovil para validar el arriendo
		
}
