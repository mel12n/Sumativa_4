package sumativa_4;

<<<<<<< HEAD
import java.util.ArrayList;

import javax.swing.JFrame;



import vista.InterfacePrincipal;
import controlador.ControladorInterfacePrincipal;


//import controlador.ControladorVistaClientes;

//import controlador.Controlador;

=======
import controlador.ControladorVistaClientes;
import java.util.ArrayList;
import javax.swing.JFrame;
import vista.Clientes;
>>>>>>> branch 'master' of https://github.com/mel12n/Sumativa_4

//import controlador.ControladorVistaClientes;
//import controlador.Controlador;
public class main {

<<<<<<< HEAD
		// main vista principal
		public static void main(String[] args) {


			InterfacePrincipal menu = new InterfacePrincipal();
			JFrame ventana3 = new JFrame("Menú Principal");
			menu.crearGUI(ventana3);
			
			ControladorInterfacePrincipal controlador = new ControladorInterfacePrincipal(menu);

			
		}
=======
    //Main para probar la vista AgregarCliente
    public static void main(String[] args) {

        AbrirDocumento abrirDocumento = new AbrirDocumento(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        abrirDocumento.cargarListaClientes();
        abrirDocumento.cargarListaArriendos();
        abrirDocumento.cargarListaAutomoviles();

        JFrame ventana = new JFrame("Agregar Cliente");
        Clientes vistaClientes = new Clientes();
        vistaClientes.crearGUI(ventana);
        ControladorVistaClientes controlador = new ControladorVistaClientes(vistaClientes);
        ventana.setLocationRelativeTo(null);
    }
>>>>>>> branch 'master' of https://github.com/mel12n/Sumativa_4

}
