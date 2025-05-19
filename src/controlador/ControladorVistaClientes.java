package controlador;

import vista.Clientes;
import sumativa_4.*;


import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



public class ControladorVistaClientes {
	// Atributos
	private Clientes agregarCliente;
<<<<<<< HEAD
=======
	private ControladorInterfacePrincipal controladorInterfacePrincipal;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Automovil> listaAutomoviles;
	private ArrayList<Arriendo> listaArriendos;
	
>>>>>>> branch 'master' of https://github.com/mel12n/Sumativa_4
	
	// Constructor
	public ControladorVistaClientes(Clientes pAgregarCliente, ControladorInterfacePrincipal pControlador) {
	    this.agregarCliente = pAgregarCliente;
	    this.controladorInterfacePrincipal = pControlador;
	    this.listaClientes = pControlador.getListaClientes(); // ← Todo bien ahora
	
		
<<<<<<< HEAD
		this.agregarCliente = pAgregarCliente;
                    
=======
		//AbrirDocumento abrirDocumento = new AbrirDocumento(null, null, null);
        //listaClientes = ControladorInterfacePrincipal.getListaClientes();
        
                     
>>>>>>> branch 'master' of https://github.com/mel12n/Sumativa_4
        // acciones del botón agregar
		agregarCliente.getBtnAgregar().addActionListener(e -> {
			String nombre = agregarCliente.getTxtNombre().getText();
			String cedula = agregarCliente.getTxtCedula().getText();
			
			for (Cliente cliente : ) {
				if (cliente.getCedula().equals(cedula)) {
					Boolean estado = cliente.getVigencia();
					String vigente = String.valueOf(estado);
					agregarCliente.getLblEstado().setText(vigente);
					JOptionPane.showMessageDialog(null, "El cliente con cédula " + cedula + " ya existe.",
						    "Cliente existente", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}

			try {
				Cliente cliente = new Cliente(cedula, nombre);
				agregarCliente(cliente);
				Window window = SwingUtilities.getWindowAncestor(agregarCliente);
			    if (window != null) {
			        window.dispose(); // Cierra la ventana actual
			    }
				for (Cliente cli : listaClientes) { 
					System.out.println("Cliente: "+ cli); // Borrar
				}
			} catch (DatoInvalidoException e1) {
		        // Mostrar mensaje de error con los detalles de la validación
		        JOptionPane.showMessageDialog(agregarCliente,
		            e1.getMessage(), // e1 Captura el mensaje de la excepción configurada en la clase Cliente
		            "Dato inválido",
		            JOptionPane.ERROR_MESSAGE);
		    }
		});
		
	}
	
	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		GuardarDocumento guardarDocumento = new GuardarDocumento(null, null, null);
		guardarDocumento.guardarCliente(listaClientes);
		
	}
	
}

