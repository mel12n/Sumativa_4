package sumativa_4;

//import java.util.ArrayList;
import javax.swing.JFrame;
import vista.InterfacePrincipal;
import controlador.ControladorInterfacePrincipal;

public class main {


		// main vista principal
		public static void main(String[] args) {


			InterfacePrincipal menu = new InterfacePrincipal();
			JFrame ventana3 = new JFrame("Menú Principal");
			menu.crearGUI(ventana3);
			
			ControladorInterfacePrincipal controlador = new ControladorInterfacePrincipal(menu);

			
		}
    
    

}
