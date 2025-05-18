package sumativa_4;

public class DatoInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }
    
}