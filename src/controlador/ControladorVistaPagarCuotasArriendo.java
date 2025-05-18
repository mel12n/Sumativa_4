package controlador;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import sumativa_4.*;
import vista.PagarCuotasArriendo;

public class ControladorVistaPagarCuotasArriendo {

    private PagarCuotasArriendo view;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Arriendo> listaArriendos;
    private ArrayList<ArriendoCuota> arriendosConCuotas;
    private ArrayList<ArriendoCuota> filteredArriendos;
    private ArriendoCuota arriendoSeleccionado;

    public ControladorVistaPagarCuotasArriendo(PagarCuotasArriendo view) {
        this.view = view;

        // Cargar datos desde archivos
        AbrirDocumento abrir = new AbrirDocumento(null, null, null);
        listaClientes = abrir.cargarListaClientes();
        listaArriendos = abrir.cargarListaArriendos();

        // Filtrar solo los arriendos que tienen cuotas
        arriendosConCuotas = new ArrayList<>();
        for (Arriendo arr : listaArriendos) {
            if (arr instanceof ArriendoCuota) {
                arriendosConCuotas.add((ArriendoCuota) arr);
            }
        }
        filteredArriendos = new ArrayList<>();

        // Poblar el combo de clientes
        view.getCmbClientes().removeAllItems();
        view.getCmbClientes().addItem("Seleccione cliente");
        for (Cliente cli : listaClientes) {
            view.getCmbClientes().addItem(cli.getCedula());
        }

        // Ocultar todos los checkboxes al inicio
        for (JCheckBox chk : view.getChkSelec()) {
            chk.setVisible(false);
        }

        // Asociar listeners
        view.getCmbClientes().addActionListener(e -> cargarArriendosPorCliente());
        view.getBtnMostrarPagos().addActionListener(e -> mostrarPagos());
        view.getBtnRealizarPago().addActionListener(e -> realizarPago());
    }

    private void cargarArriendosPorCliente() {
        String cedula = (String) view.getCmbClientes().getSelectedItem();
        DefaultListModel<String> modelArriendos = new DefaultListModel<>();
        filteredArriendos.clear();

        if (cedula != null && !cedula.equals("Seleccione cliente")) {
            for (ArriendoCuota arr : arriendosConCuotas) {
                if (arr.getCliente().getCedula().equals(cedula)) {
                    filteredArriendos.add(arr);
                    modelArriendos.addElement(arr.toString());
                }
            }
        }

        view.getLstArriendos().setModel(modelArriendos);
    }

    private void mostrarPagos() {
        int idx = view.getLstArriendos().getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(view,
                    "Seleccione un arriendo primero.",
                    "Atención",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        arriendoSeleccionado = filteredArriendos.get(idx);
        ArrayList<CuotaArriendo> cuotas = arriendoSeleccionado.getCuotas();
        if (cuotas == null || cuotas.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                    "No hay cuotas registradas para este arriendo.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Rellenar la tabla de cuotas
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblCuotas().getModel();
        tableModel.setRowCount(0);
        for (CuotaArriendo c : cuotas) {
            tableModel.addRow(new Object[]{
                String.valueOf(c.getNumeroCuota()),
                String.valueOf(c.getValorCuota()),
                c.getPagada()
            });
        }

        // Mostrar checkboxes al lado de cada cuota no pagada
        JCheckBox[] chks = view.getChkSelec();
        for (int i = 0; i < chks.length; i++) {
            if (i < cuotas.size() && !cuotas.get(i).getPagada()) {
                chks[i].setVisible(true);
                chks[i].setSelected(false);
            } else {
                chks[i].setVisible(false);
            }
        }
    }

    private void realizarPago() {
        if (arriendoSeleccionado == null) {
            JOptionPane.showMessageDialog(view,
                    "No hay ningún arriendo seleccionado.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<CuotaArriendo> cuotas = arriendoSeleccionado.getCuotas();
        JCheckBox[] chks = view.getChkSelec();
        boolean anySelected = false;

        for (int i = 0; i < chks.length && i < cuotas.size(); i++) {
            if (chks[i].isVisible() && chks[i].isSelected()) {
                cuotas.get(i).setPagada(true);
                anySelected = true;
            }
        }

        if (!anySelected) {
            JOptionPane.showMessageDialog(view,
                    "Seleccione al menos una cuota para pagar.",
                    "Atención",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Guardar los cambios en el archivo de arriendos
        GuardarDocumento guardar = new GuardarDocumento(null, listaArriendos, null);
        guardar.guardarArriendo(listaArriendos);

        // Refrescar la vista para reflejar los nuevos estados
        mostrarPagos();
    }
}
