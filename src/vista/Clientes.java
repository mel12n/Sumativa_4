package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtTrue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 90, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(51, 82, 49, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(51, 120, 49, 27);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField(); // Cédula
		textField.setBounds(110, 86, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(); // Nombre
		textField_1.setColumns(10);
		textField_1.setBounds(110, 124, 200, 20);
		contentPane.add(textField_1);
		
		Label label = new Label("¿ Vigente ?:");
		label.setBounds(178, 166, 62, 22);
		contentPane.add(label);
		
		txtTrue = new JTextField(); // Label True
		txtTrue.setText("True");
		txtTrue.setEditable(false);
		txtTrue.setColumns(10);
		txtTrue.setBounds(246, 168, 31, 20);
		contentPane.add(txtTrue);
		
		JButton btnAgregarCliente = new JButton("Agregar"); //Agregar cliente
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarCliente.setBounds(246, 207, 89, 23);
		contentPane.add(btnAgregarCliente);
	}
}
