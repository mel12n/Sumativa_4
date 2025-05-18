package sumativa_4;

import javax.swing.JFrame;

import vista.Clientes;
import controlador.ControladorVistaAgregarCliente;

public class main {

	//Main para probar la vista AgregarCliente
		public static void main(String[] args) {
	        JFrame ventana = new JFrame("Agregar Cliente");
	        Clientes vista = new Clientes();
	        vista.crearGUI(ventana);
	        new ControladorVistaAgregarCliente(vista);
	    }


}
