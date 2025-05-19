package controlador;

import vista.*;
import sumativa_4.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorInterfacePrincipal {

    private InterfacePrincipal vista;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Arriendo> listaArriendos;
    private ArrayList<Automovil> listaAutomoviles;

    public ControladorInterfacePrincipal(InterfacePrincipal vista) {
        this.vista = vista;
        
        AbrirDocumento abrirDocumentos = new AbrirDocumento(null,null,null);
        listaClientes = abrirDocumentos.cargarListaClientes();
        listaArriendos = abrirDocumentos.cargarListaArriendos();
        listaAutomoviles = abrirDocumentos.cargarListaAutomoviles();

        // Botón Arriendos
        vista.getBtnArriendos().addActionListener(e -> {
            JFrame ventana = new JFrame("Arriendos con Cuotas");
            ArriendoConCuotas vistaArriendo = new ArriendoConCuotas();
            vistaArriendo.crearGUI(ventana);
            ControladorVistaArriendo controlador = new ControladorVistaArriendo(vistaArriendo, this);
        });

        // Botón Clientes
        vista.getBtnClientes().addActionListener(e -> {
        	JFrame ventana = new JFrame("Clientes");
            Clientes vistaClientes = new Clientes();
            vistaClientes.crearGUI(ventana);      
            ControladorVistaClientes controlador = new ControladorVistaClientes(vistaClientes, this);
            
            ventana.setLocationRelativeTo(null);
            //ventana.setVisible(true); // Para mostrar la ventana
        });

        // Botón Autos
        vista.getBtnVehiculos().addActionListener(e -> {
			JFrame ventana = new JFrame("Automoviles");
			Automoviles vistaAutos = new Automoviles();
			vistaAutos.crearGUI(ventana);
			ControladorVistaAutomoviles controlador = new ControladorVistaAutomoviles(vistaAutos, this);
			
			ventana.setLocationRelativeTo(null);
			//ventana.setVisible(true); // Para mostrar la ventana
		});
        
        // Botón Pagar Cuotas
        vista.getBtnPagarCuotasArriendo().addActionListener(e -> {
			JFrame ventana = new JFrame("Pagar Cuotas");
			PagarCuotasArriendo vistaPagarCuotas = new PagarCuotasArriendo();
			vistaPagarCuotas.crearGUI(ventana);
			ControladorVistaPagarCuotasArriendo controlador = new ControladorVistaPagarCuotasArriendo(vistaPagarCuotas);
			ventana.setLocationRelativeTo(null);
		});
        /*SwingUtilities.invokeLater(() -> {
            PagarCuotasArriendo view = new PagarCuotasArriendo();
            JFrame frame = new JFrame();
            view.crearGUI(frame);
            // Asociar el controlador a la vista
            new ControladorVistaPagarCuotasArriendo(view);
        });*/
        
    }
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
    public void setListaArriendos(ArrayList<Arriendo> listaArriendos) {
    	this.listaArriendos = listaArriendos;
    }
    public void setListaAutomoviles(ArrayList<Automovil> listaAutomoviles) {
		this.listaAutomoviles = listaAutomoviles;
	}
    public ArrayList<Cliente> getListaClientes() {
    	return listaClientes;
    }
    public ArrayList<Arriendo> getListaArriendos() {
		return listaArriendos;
	}
    public ArrayList<Automovil> getListaAutomoviles() {
    	return listaAutomoviles;
    }
    
   
} 