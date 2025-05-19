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
    private ControladorInterfacePrincipal controladorInterfacePrincipal;
    private ArrayList<Cliente> listaClientes;
    

    // Constructor
    public ControladorVistaClientes(Clientes pAgregarCliente, ControladorInterfacePrincipal pControlador) {
        this.agregarCliente = pAgregarCliente;
        this.controladorInterfacePrincipal = pControlador;
        this.listaClientes = pControlador.getListaClientes(); // ← Todo bien ahora


        //AbrirDocumento abrirDocumento = new AbrirDocumento(null, null, null);
        //listaClientes = ControladorInterfacePrincipal.getListaClientes();


        // acciones del botón agregar
        agregarCliente.getBtnAgregar().addActionListener(e -> {
            String nombre = agregarCliente.getTxtNombre().getText();
            String cedula = agregarCliente.getTxtCedula().getText();

            for (Cliente cliente : listaClientes) {
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
                    System.out.println("Cliente: "+ cli); // Para depuración
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