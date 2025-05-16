package sumativa_4;

public class Arriendo {
	
	// Atributos
	private int numArriendo;
	private String fecArr; // fecha de arriendo
	private int diasArriendo;
	
	// Constructor
	public Arriendo(int pNumArriendo, String pFecArr, int pDiasArriendo) {
		this.numArriendo = pNumArriendo;
		this.fecArr = pFecArr;
		this.diasArriendo = pDiasArriendo;
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
	
	// Método toString
	@Override
	public String toString() {
		return "Arriendo [número:" + numArriendo + ", fecha:" + fecArr + ", dias de arriendo:" + diasArriendo + "]";
	}
	
	
	
	
}
