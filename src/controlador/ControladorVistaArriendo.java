package controlador;

import vista.ArriendoConCuotas;
import vista.Clientes;
import sumativa_4.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class ControladorVistaArriendo {

    private ArriendoConCuotas vista;
    private ArrayList<Cliente> listaClientes;

    public ControladorVistaArriendo(ArriendoConCuotas vista) {
        this.vista = vista;
        this.listaClientes = new ArrayList<>();

        cargarClientes();

        vista.getBtnGuardar().addActionListener(this::calcularArriendo);
        vista.getBtnPagar().addActionListener(this::pagarCuota);
        vista.getBtnNuevoCliente().addActionListener(e -> abrirVistaClientes());
    }

    private void cargarClientes() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            listaClientes = (ArrayList<Cliente>) in.readObject();
            vista.getComboClientes().removeAllItems();
            vista.getComboClientes().addItem("Seleccione CLIENTE");
            for (Cliente c : listaClientes) {
                vista.getComboClientes().addItem(c.getNombre());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No hay clientes registrados aún.");
        }
    }

    private void calcularArriendo(ActionEvent e) {
        try {
            int dias = Integer.parseInt(vista.getTxtDias().getText());
            double precioDia = Double.parseDouble(vista.getTxtPrecioDia().getText());
            int cuotas = Integer.parseInt(vista.getTxtCuotas().getText());

            double montoTotal = dias * precioDia;
            vista.getTxtMontoTotal().setText(String.format("%.2f", montoTotal));

            // Crear modelo de tabla
            DefaultTableModel modelo = new DefaultTableModel(new String[]{"Número", "Valor", "¿Pagada?"}, 0);
            double valorCuota = montoTotal / cuotas;
            for (int i = 1; i <= cuotas; i++) {
                modelo.addRow(new Object[]{i, String.format("%.2f", valorCuota), "NO"});
            }
            vista.getTablaCuotas().setModel(modelo);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa valores válidos en días, precio y cuotas.");
        }
    }

    private void pagarCuota(ActionEvent e) {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaCuotas().getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if ("NO".equals(modelo.getValueAt(i, 2))) {
                modelo.setValueAt("SÍ", i, 2);
                JOptionPane.showMessageDialog(null, "Primera cuota marcada como pagada.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Todas las cuotas ya están pagadas.");
    }

    private void abrirVistaClientes() {
        JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(vista);
        ventana.getContentPane().removeAll();

        Clientes nuevaVista = new Clientes();
        ventana.add(nuevaVista);
        ventana.revalidate();
        ventana.repaint();

        new ControladorVistaClientes(nuevaVista);
    }
}


