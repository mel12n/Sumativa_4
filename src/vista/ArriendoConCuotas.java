package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ArriendoConCuotas extends JPanel {
    
	private static final long serialVersionUID = 1L;
	// Componentes visuales
    private JComboBox<String> comboClientes, comboAutos;
    private JButton btnNuevoCliente, btnGuardar, btnPagar;
    private JTextField txtFecha, txtDias, txtPrecioDia, txtMontoTotal, txtCuotas;
    private JLabel lblTitulo, lblFecha, lblDias, lblPrecioDia, lblMonto, lblCuotas, lblFormatoFecha;
    private JTable tablaCuotas;
    private JScrollPane scrollTabla;

    public ArriendoConCuotas() {
        setLayout(null);
        
        
        lblTitulo = new JLabel("ARRIENDOS CON CUOTAS");
        lblTitulo.setBounds(420, 20, 300, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo);
        
        lblFecha = new JLabel("Fecha Arriendo:");
        lblFecha.setBounds(80, 170, 120, 25);
        add(lblFecha);
        
        lblFormatoFecha = new JLabel("(DD-MM-YYYY)");
        lblFormatoFecha.setBounds(80, 183, 120, 25);
        lblFormatoFecha.setFont(new Font("Arial", Font.BOLD, 10));
        add(lblFormatoFecha);
        
        lblCuotas = new JLabel("Cantidad de cuotas:");
        lblCuotas.setBounds(420, 170, 150, 25);
        add(lblCuotas);
        
        lblDias = new JLabel("Días:");
        lblDias.setBounds(80, 210, 100, 25);
        add(lblDias);
        
        lblPrecioDia = new JLabel("Precio por día:");
        lblPrecioDia.setBounds(80, 250, 100, 25);
        add(lblPrecioDia);
        
        lblMonto = new JLabel("MONTO A PAGAR:");
        lblMonto.setBounds(80, 290, 120, 25);
        add(lblMonto);
        
        txtFecha = new JTextField();
        txtFecha.setBounds(200, 170, 100, 25);
        add(txtFecha);

        txtCuotas = new JTextField();
        txtCuotas.setBounds(580, 170, 50, 25);
        add(txtCuotas);

        txtDias = new JTextField();
        txtDias.setBounds(200, 210, 100, 25);
        add(txtDias);

        txtPrecioDia = new JTextField();
        txtPrecioDia.setBounds(200, 250, 100, 25);
        add(txtPrecioDia);

        txtMontoTotal = new JTextField();
        txtMontoTotal.setBounds(200, 290, 100, 25);
        txtMontoTotal.setEditable(false);
        add(txtMontoTotal);

        comboClientes = new JComboBox<>(new String[]{"Seleccione CLIENTE"});
        comboClientes.setBounds(100, 70, 250, 30);
        add(comboClientes);
        
        comboAutos = new JComboBox<>(new String[]{"Seleccione AUTOMOVIL"});
        comboAutos.setBounds(420, 70, 250, 30);
        add(comboAutos);

        btnNuevoCliente = new JButton("Ingresar nuevo Cliente");
        btnNuevoCliente.setBounds(140, 110, 180, 30);
        add(btnNuevoCliente);
        
        btnGuardar = new JButton("Guardar arriendo y mostrar  cuotas >>");
        btnGuardar.setBounds(420, 210, 300, 30);
        add(btnGuardar);
        
        btnPagar = new JButton("Pagar Primera Cuota");
        btnPagar.setBounds(860, 320, 180, 30);
        add(btnPagar);

     // Tabla de cuotas
        String[] columnas = {"Número", "Valor", "¿Pagada?"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);
        tablaCuotas = new JTable(modeloTabla);  // ← usa la variable de instancia
        scrollTabla = new JScrollPane(tablaCuotas);
        tablaCuotas.getTableHeader().setReorderingAllowed(false);
        scrollTabla.setBounds(800, 100, 280, 200);
        tablaCuotas.setBackground(Color.WHITE); 
        scrollTabla.getViewport().setBackground(Color.WHITE);
        add(scrollTabla);

   
    }
    public JButton getBtnGuardar() {
        return btnGuardar;
    }
    public JButton getBtnPagar() {
        return btnPagar;
    }

    public JButton getBtnNuevoCliente() {
        return btnNuevoCliente;
    }

    public JComboBox<String> getComboClientes() {
        return comboClientes;
    }
    public JComboBox<String> getComboAutos() {
        return comboAutos;
    }

    public JTable getTablaCuotas() {
        return tablaCuotas;
    }

    public JTextField getTxtDias() {
        return txtDias;
    }

    public JTextField getTxtPrecioDia() {
        return txtPrecioDia;
    }

    public JTextField getTxtCuotas() {
        return txtCuotas;
    }

    public JTextField getTxtMontoTotal() {
        return txtMontoTotal;
    }
    public JTextField getTxtFecha() {
		return txtFecha;
	}
    


    public void crearGUI(JFrame ventana) {
        this.setBackground(new Color(240, 240, 240));
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setSize(1120, 420);
        ventana.setResizable(false);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Arriendos con Cuotas");
        ArriendoConCuotas vista = new ArriendoConCuotas();
        vista.crearGUI(ventana);
    }
}


