package sumativa_4;

import javax.swing.JFrame;

import vista.Clientes;
<<<<<<< HEAD
import controlador.ControladorVistaClientes;
=======
import controlador.Controlador;
>>>>>>> branch 'master' of https://github.com/mel12n/Sumativa_4

public class main {

	//Main para probar la vista AgregarCliente
		public static void main(String[] args) {
	        JFrame ventana = new JFrame("Agregar Cliente");
	        Clientes vista = new Clientes();
	        vista.crearGUI(ventana);
<<<<<<< HEAD
	        new ControladorVistaClientes(vista);
=======
	        new Controlador(vista);
>>>>>>> branch 'master' of https://github.com/mel12n/Sumativa_4
	    }
}
