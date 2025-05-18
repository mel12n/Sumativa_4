package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PagarCuotasArriendo extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel lblTitulo;
    private JComboBox<String> cmbClientes;
    private JList<String> lstArriendos;
    private DefaultListModel<String> modelArriendos;
    private JButton btnMostrarPagos;
    private final JTable tblCuotas;
    private final DefaultTableModel modelCuotas;
    private final JButton btnRealizarPago;
    private JCheckBox[] chkSelec;

    public PagarCuotasArriendo() {
        setLayout(null);
        setBackground(new Color(250, 245, 240));

        // 1) Title
        lblTitulo = new JLabel("PAGAR CUOTAS ARRIENDOS", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(10, 10, 900, 25);
        add(lblTitulo);

        // 2) “Seleccione arriendo” list on the left
        modelArriendos = new DefaultListModel<>();
        lstArriendos = new JList<>(modelArriendos);
        lstArriendos.setBorder(BorderFactory.createTitledBorder("Seleccione arriendo"));
        JScrollPane spArriendos = new JScrollPane(lstArriendos);
        spArriendos.setBounds(10, 45, 300, 215);
        add(spArriendos);

        // 3) Show payments button
        btnMostrarPagos = new JButton("Mostrar pagos arriendo seleccionado »");
        btnMostrarPagos.setBounds(340, 115, 260, 25);
        add(btnMostrarPagos);

        // 4) Client selector in middle, above the button
        cmbClientes = new JComboBox<>(new String[]{"Seleccione cliente"});
        cmbClientes.setBounds(340, 80, 260, 25);
        add(cmbClientes);

        // 5) “PAGOS” label
        JLabel lblPagos = new JLabel("PAGOS");
        lblPagos.setFont(new Font("Arial", Font.BOLD, 14));
        lblPagos.setBounds(630, 45, 80, 20);
        add(lblPagos);

        // 6) Standalone checkboxes alongside the payment table (remove the first)
        int checkboxCount = 6;
        chkSelec = new JCheckBox[checkboxCount];
        for (int i = 0; i < checkboxCount; i++) {
            chkSelec[i] = new JCheckBox();
            chkSelec[i].setBounds(610, 110 + i * 30, 20, 20);
            add(chkSelec[i]);
        }

        // 7) Table of cuotas
        String[] cols = {"Número", "Valor", "¿Pagada?"};
        modelCuotas = new DefaultTableModel(cols, 0) {
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

        // 8) Realizar Pago button
        btnRealizarPago = new JButton("Realizar Pago");
        btnRealizarPago.setBounds(630, 300, 140, 25);
        add(btnRealizarPago);
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
