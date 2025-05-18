package vista;

import javax.swing.*;
import java.awt.*;

public class InterfacePrincipal extends JPanel {

    private static final long serialVersionUID = 1L;
    private JButton btnArriendos, btnClientes, btnAutos, btnVehiculos;
    private JLabel lblTitulo;

    public InterfacePrincipal() {
        setLayout(null);
        setBackground(new Color(230, 240, 250));

        // Título
        lblTitulo = new JLabel("SISTEMA DE ARRIENDOS", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBounds(300, 40, 400, 40);
        add(lblTitulo);

        // Botón Arriendos
        btnArriendos = new JButton("Gestionar Arriendos");
        btnArriendos.setFont(new Font("Arial", Font.PLAIN, 16));
        btnArriendos.setBounds(380, 120, 250, 50);
        add(btnArriendos);

        // Botón Autos
        btnAutos = new JButton("Pagar Cuotas de Arriendo");
        btnAutos.setFont(new Font("Arial", Font.PLAIN, 16));
        btnAutos.setBounds(380, 200, 250, 50);
        add(btnAutos);

        // Botón Clientes
        btnClientes = new JButton("Agregar Clientes");
        btnClientes.setFont(new Font("Arial", Font.PLAIN, 16));
        btnClientes.setBounds(380, 280, 250, 50);
        add(btnClientes);

        // Botón Vehículos
        btnVehiculos = new JButton("Agregar Vehículos");
        btnVehiculos.setFont(new Font("Arial", Font.PLAIN, 16));
        btnVehiculos.setBounds(380, 360, 250, 50);
        add(btnVehiculos);
    }

    public JButton getBtnArriendos() {
        return btnArriendos;
    }

    public JButton getBtnClientes() {
        return btnClientes;
    }

    public JButton getBtnAutos() {
        return btnAutos;
    }

    public JButton getBtnVehiculos() {
        return btnVehiculos;
    }

    public void crearGUI(JFrame ventana) {
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setSize(1000, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setResizable(false);
    }
} 
