package sumativa_4;

public class ArriendoCuota extends Arriendo {
	
	// atributos
	private int cantidadCuotas;
	
	// constructor
	public ArriendoCuota(int pNumArriendo, String pFecArr, int pDiasArriendo, int pPrecioDia, int pCantidadCuotas) {
		super(pNumArriendo, pFecArr, pDiasArriendo, pPrecioDia);
		this.cantidadCuotas = pCantidadCuotas;
	}
	
	// getters
	public int getCantidadCuotas() {
		return cantidadCuotas;
	}
	
	// setters
	public void setCantidadCuotas(int pCantidadCuotas) {
		this.cantidadCuotas = pCantidadCuotas;
	}
	
	// método toString
	
	@Override
	public String toString() {
		return super.toString() + ", cantidad de cuotas: " + getCantidadCuotas(); 
	}

}
