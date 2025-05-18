package sumativa_4;

import javax.swing.JFrame;
import vista.ArriendoConCuotas;
import controlador.ControladorVistaArriendo;

public class main {

	//Main para probar la vista AgregarCliente
		public static void main(String[] args) {
	        JFrame ventana = new JFrame("Arriendo con Cuotas");
	        ArriendoConCuotas vista = new ArriendoConCuotas();
	        vista.crearGUI(ventana);
	        ControladorVistaArriendo controlador = new ControladorVistaArriendo(vista);
	        
		}
}