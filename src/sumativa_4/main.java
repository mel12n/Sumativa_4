package sumativa_4;

import java.util.ArrayList;

import javax.swing.JFrame;

import vista.Clientes;

import controlador.ControladorVistaClientes;

//import controlador.ControladorVistaClientes;

//import controlador.Controlador;


public class main {

	//Main para probar la vista AgregarCliente
		public static void main(String[] args) {
<<<<<<< HEAD
	        JFrame ventana = new JFrame("Arriendo con Cuotas");
	        ArriendoConCuotas vista = new ArriendoConCuotas();
	        vista.crearGUI(ventana);
	        ControladorVistaArriendo controlador = new ControladorVistaArriendo(vista);
	        ventana.setLocationRelativeTo(null); // Centra la ventana
=======
			
			AbrirDocumento abrirDocumento = new AbrirDocumento(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
			abrirDocumento.cargarListaClientes();
			abrirDocumento.cargarListaArriendos();
			abrirDocumento.cargarListaAutomoviles();
			
	        			
			JFrame ventana = new JFrame("Agregar Cliente");
	        Clientes vistaClientes = new Clientes();
	        vistaClientes.crearGUI(ventana);
	        ControladorVistaClientes controlador = new ControladorVistaClientes(vistaClientes);
	        ventana.setLocationRelativeTo(null); 
>>>>>>> branch 'master' of https://github.com/mel12n/Sumativa_4
		}

}
