package sumativa_4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GuardarDocumento implements Serializable {
	
	// Atributos
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Arriendo> listaArriendos;
	private ArrayList<Automovil> listaAutomoviles;
	
	//private Cliente agregarCliente;
	
	// Constructor
	public GuardarDocumento(ArrayList<Cliente> pListaClientes, ArrayList<Arriendo> pListaArriendos, ArrayList<Automovil> pListaAutomoviles) {
		this.listaClientes = pListaClientes;
		this.listaArriendos = pListaArriendos;
		this.listaAutomoviles = pListaAutomoviles;
	}
	
	// Setters
	public void setListaClientes(ArrayList<Cliente> pListaClientes) {
		this.listaClientes = pListaClientes;
	}
	public void setListaArriendos(ArrayList<Arriendo> pCuotas) {
		this.listaArriendos = pCuotas;
	}
	public void setListaAutomoviles(ArrayList<Automovil> pListaAutomoviles) {
		this.listaAutomoviles = pListaAutomoviles;
	}
	
	// Getters
	public ArrayList<Cliente> getListaClientes() {
		return this.listaClientes;
	}
	public ArrayList<Arriendo> getListaArriendos() {
		return this.listaArriendos;
	}
	public ArrayList<Automovil> getListaAutomoviles() {
		return this.listaAutomoviles;
	}
	// Métodos Customer
	public void guardarCliente(ArrayList<Cliente> listaClientes2) {
		//listaClientes.add(cliente);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
			out.writeObject(listaClientes2); 
			
			JOptionPane.showMessageDialog(null, 
					"Cliente registrado correctamente.","Guardado", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Error al registrar los datos del cliente.","Error", JOptionPane.ERROR_MESSAGE);
		}
		//return listaClientes;
	}
	public void guardarArriendo(ArrayList<Arriendo> listaArriendos2) {
		//listaArriendos.add(arriendo);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("arriendos.dat"))) {
			out.writeObject(listaArriendos2); 
			
			JOptionPane.showMessageDialog(null, 
					"Arriendo registrado correctamente.","Guardado", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Error al registrar los datos del arriendo.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void guardarAutomovil(ArrayList<Automovil> listaAutomoviles2) {
		//listaAutomoviles.add(automovil);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("automoviles.dat"))) {
			out.writeObject(listaAutomoviles2); 
			
			JOptionPane.showMessageDialog(null, 
					"Automóvil registrado correctamente.","Guardado", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Error al registrar los datos del automóvil.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
