package sumativa_4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import sumativa_4.Cliente;

import javax.swing.JOptionPane;

public class GuardarDocumento implements Serializable {
	
	// Atributos
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> listaClientes;
	private Cliente agregarCliente;
	
	// Constructor
	public GuardarDocumento(ArrayList<Cliente> pListaClientes) {
		this.listaClientes = pListaClientes;
	}
	
	public void guardarCliente() {
		//listaClientes.add(cliente);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
			out.writeObject(listaClientes); 
			
			JOptionPane.showMessageDialog(null, 
					"Cliente registrado correctamente.","Guardado", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Error al registrar los datos del cliente.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
