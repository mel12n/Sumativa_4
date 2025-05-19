package vista;

import javax.swing.*;
import java.awt.*;

public class Automoviles extends JPanel {
    private static final long serialVersionUID = 1L;

    // Componentes visuales
    private JLabel lblTitulo, lblPatente, lblMarca, lblModelo, lblAnio;
    private JTextField txtPatente, txtMarca, txtModelo, txtAnio;
    private JButton btnAgregar;

    public Automoviles() {
        setLayout(null);

        // Título
        lblTitulo = new JLabel("AUTOMÓVILES");
        lblTitulo.setBounds(10, 10, 200, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo);

        // Etiquetas
        //Label Patente
        lblPatente = new JLabel("Patente:");
        lblPatente.setBounds(30, 50, 80, 25);
        add(lblPatente);
        //Label Marca
        lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(30, 90, 80, 25);
        add(lblMarca);
        //Label Modelo
        lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 130, 80, 25);
        add(lblModelo);
        //Label Año
        lblAnio = new JLabel("Año:");
        lblAnio.setBounds(30, 170, 80, 25);
        add(lblAnio);

        // Campos de texto
        txtPatente = new JTextField();
        txtPatente.setBounds(100, 50, 150, 25);
        add(txtPatente);

        txtMarca = new JTextField();
        txtMarca.setBounds(100, 90, 150, 25);
        add(txtMarca);

        txtModelo = new JTextField();
        txtModelo.setBounds(100, 130, 150, 25);
        add(txtModelo);

        txtAnio = new JTextField();
        txtAnio.setBounds(100, 170, 150, 25);
        add(txtAnio);

        // Botón
        setBtnAgregar(new JButton("Agregar"));
        getBtnAgregar().setBounds(210, 200, 100, 25);
        add(getBtnAgregar());
    }

    public void crearGUI(JFrame ventana) {
        this.setBackground(new Color(240, 240, 240));
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(400, 320);
        ventana.setVisible(true);
        ventana.setResizable(false);
    }

    // Getters
    public JTextField getTxtPatente() {
        return txtPatente;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public JTextField getTxtAnio() {
        return txtAnio;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }
    public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
}

