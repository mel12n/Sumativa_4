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
    private ArrayList<ArriendoCuota> listaArriendos;
    private ArrayList<Automovil> listaAutomoviles;

    public ControladorInterfacePrincipal(InterfacePrincipal vista) {
        this.vista = vista;

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
            ControladorVistaClientes controlador = new ControladorVistaClientes(vistaClientes);
            ventana.setLocationRelativeTo(null);
        });

        // Botón Autos
        vista.getBtnAutos().addActionListener(e -> {
            JFrame ventana = new JFrame("Automóviles");
            JOptionPane.showMessageDialog(vista, "Función aún no implementada");
        });
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Menú Principal");
        InterfacePrincipal menu = new InterfacePrincipal();
        menu.crearGUI(ventana);
        new ControladorInterfacePrincipal(menu);
    }
} 
