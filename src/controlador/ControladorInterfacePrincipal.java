package controlador;

import vista.*;
import sumativa_4.*;

import javax.swing.*;
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
            new ControladorVistaArriendo(vistaArriendo);
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
        vista.getBtnAutos().addActionListener(e -> {
            JFrame ventana = new JFrame("Automóviles");
            JOptionPane.showMessageDialog(vista, "Función aún no implementada");
        });
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
