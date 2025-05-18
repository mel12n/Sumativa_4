package sumativa_4;

import javax.swing.JFrame;

import vista.Clientes;

import controlador.ControladorVistaClientes;

//import controlador.ControladorVistaClientes;

//import controlador.Controlador;


public class main {

	//Main para probar la vista AgregarCliente
		public static void main(String[] args) {
	        JFrame ventana = new JFrame("Agregar Cliente");
	        Clientes vista = new Clientes();
	        vista.crearGUI(ventana);

	        new ControladorVistaClientes(vista);

	        //new ControladorVistaClientes(vista);

	        //new Controlador(vista);
		}

}
