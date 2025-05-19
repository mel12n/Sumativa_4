package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Clientes extends JPanel {
	
	private static final long serialVersionUID = 1L;
	// Componentes visuales
	private JLabel lblTitulo, lblCedula,lblNombre, lblVigente, lblEstado;
	private JTextField txtCedula, txtNombre;
	private JButton btnAgregar;
	
	public Clientes() {
		setLayout(null);
		
		// Labels
		//Label Clientes
		lblTitulo = new JLabel("CLIENTES");
		lblTitulo.setBounds(10, 10, 100, 30);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo);
		//Label Cédula
        lblCedula = new JLabel("Cédula:");
        lblCedula.setBounds(30, 50, 80, 25);
        add(lblCedula);
        //Label Nombre
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 90, 80, 25);
        add(lblNombre);
        //Label Vigente
        lblVigente = new JLabel("¿ Vigente ?:");
        lblVigente.setBounds(130, 130, 80, 25);
        add(lblVigente);
        //Label Estado
        lblEstado = new JLabel("True");
        //setLblEstado(new JLabel("True"));//Asignar luego estado en el controlador
        lblEstado.setBounds(200, 130, 40, 25);
        add(lblEstado);
        //Cuadro de texto Cédula
        setTxtCedula(new JTextField());
        getTxtCedula().setBounds(100, 50, 150, 25);
        add(getTxtCedula());
        //Cuadro de texto Nombre
        setTxtNombre(new JTextField());
        getTxtNombre().setBounds(100, 90, 200, 25);
        add(getTxtNombre());
        //Botón Agregar
        setBtnAgregar(new JButton("Agregar"));
        getBtnAgregar().setBounds(210, 200, 100, 25);
        add(getBtnAgregar());
	}
	
	public void crearGUI(JFrame ventana) {
		this.setBackground(new Color(240, 240, 240));
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventana.setSize(400, 300);
		ventana.setVisible(true);
		ventana.setResizable(false);
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}
}
