package sumativa_4;

public class CuotaArriendo {
	
	// Atributos
	
	public int numeroCuota;
	public int valorCuota;
	public boolean pagada;
	
	// Constructor
	public CuotaArriendo(int pNumeroCuota, int pValorCuota) {
		this.numeroCuota = pNumeroCuota;
		this.valorCuota = pValorCuota;
		this.pagada = false;
	}
	
	// Setters
	public void setNumeroCuota(int pNumeroCuota) {
		this.numeroCuota = pNumeroCuota;
	}
	public void setValorCuota(int pValorCuota) {
		this.valorCuota = pValorCuota;
	}
	public void setPagada(boolean pPagada) {
		this.pagada = pPagada;
	}
	
	// Getters
	public int getNumeroCuota() {
		return this.numeroCuota;
	}
	public int getValorCuota() {
		return this.valorCuota;
	}
	public boolean getPagada() {
		return this.pagada;
	}
	
	// Método toString
	@Override
	public String toString() {
		return "CuotaArriendo [numeroCuota=" + numeroCuota + ", valorCuota=" + valorCuota + ", pagada=" + pagada + "]";
	}
	
	// Métodos customer
	public boolean pagarCuota() {
		if (cuotas.contains(getNumeroCuota())) {
			setPagada(true);
			return true;
		} else {
			return false;
		}
	}
}
