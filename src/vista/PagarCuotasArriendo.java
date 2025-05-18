package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PagarCuotasArriendo extends JPanel {

    private static final long serialVersionUID = 1L;

    // Componentes de la interfaz
    private JLabel lblTitulo;
    private JComboBox<String> cmbClientes;
    private JList<String> lstArriendos;
    private DefaultListModel<String> modelArriendos;
    private JButton btnMostrarPagos;
    private JTable tblCuotas;
    private DefaultTableModel modelCuotas;
    private JButton btnRealizarPago;
    private JCheckBox[] chkSelec;

    public PagarCuotasArriendo() {
        setLayout(null);
        setBackground(new Color(250, 245, 240));

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // 1) Título
        lblTitulo = new JLabel("PAGAR CUOTAS ARRIENDOS", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(10, 10, 900, 25);
        add(lblTitulo);

        // 2) Lista de arriendos (izquierda)
        modelArriendos = new DefaultListModel<>();
        lstArriendos = new JList<>(modelArriendos);
        lstArriendos.setBorder(BorderFactory.createTitledBorder("Seleccione arriendo"));
        JScrollPane spArriendos = new JScrollPane(lstArriendos);
        spArriendos.setBounds(10, 45, 300, 215);
        add(spArriendos);

        // 3) Selector de cliente (centro, encima del botón)
        cmbClientes = new JComboBox<>(new String[]{"Seleccione cliente"});
        cmbClientes.setBounds(340, 80, 260, 25);
        add(cmbClientes);

        // 4) Botón para mostrar pagos del arriendo seleccionado
        btnMostrarPagos = new JButton("Mostrar pagos arriendo seleccionado »");
        btnMostrarPagos.setBounds(340, 115, 260, 25);
        add(btnMostrarPagos);

        // 5) Etiqueta PAGOS
        JLabel lblPagos = new JLabel("PAGOS");
        lblPagos.setFont(new Font("Arial", Font.BOLD, 14));
        lblPagos.setBounds(630, 45, 80, 20);
        add(lblPagos);

        // 6) Checkboxes junto a la tabla de cuotas
        int cantidadCheck = 6;
        chkSelec = new JCheckBox[cantidadCheck];
        for (int i = 0; i < cantidadCheck; i++) {
            chkSelec[i] = new JCheckBox();
            chkSelec[i].setBounds(610, 110 + i * 30, 20, 20);
            add(chkSelec[i]);
        }

        // 7) Tabla de cuotas
        String[] columnas = {"Número", "Valor", "¿Pagada?"};
        modelCuotas = new DefaultTableModel(columnas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 2;
            }
        };
        tblCuotas = new JTable(modelCuotas);
        tblCuotas.setFillsViewportHeight(true);
        JScrollPane spCuotas = new JScrollPane(tblCuotas);
        spCuotas.setBounds(630, 80, 260, 215);
        add(spCuotas);

        // 8) Botón para realizar el pago
        btnRealizarPago = new JButton("Realizar Pago");
        btnRealizarPago.setBounds(630, 300, 140, 25);
        add(btnRealizarPago);
    }

    public JComboBox<String> getCmbClientes() {
        return cmbClientes;
    }

    public JList<String> getLstArriendos() {
        return lstArriendos;
    }

    public JTable getTblCuotas() {
        return tblCuotas;
    }

    public JButton getBtnMostrarPagos() {
        return btnMostrarPagos;
    }

    public JButton getBtnRealizarPago() {
        return btnRealizarPago;
    }

    public JCheckBox[] getChkSelec() {
        return chkSelec;
    }

    public void crearGUI(JFrame frame) {
        frame.setTitle("Pagar Cuotas Arriendos");
        frame.setSize(920, 380);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            new PagarCuotasArriendo().crearGUI(f);
        });
    }
}
