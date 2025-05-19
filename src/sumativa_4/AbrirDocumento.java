package sumativa_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class AbrirDocumento {
	// Atributos
	
	private ArrayList<Cliente> listaClientes;
	private ArrayList<ArriendoCuota> listaArriendos;
	private ArrayList<Automovil> listaAutomoviles;// en que casos es Final?
	
	// Constructor
	
	public AbrirDocumento(ArrayList<Cliente> pListaClientes, ArrayList<ArriendoCuota> pListaArriendos, ArrayList<Automovil> pListaAutomoviles) {
		
		this.listaClientes = pListaClientes;
		this.listaArriendos = pListaArriendos;
		this.listaAutomoviles = pListaAutomoviles;
		//cargarListaClientes();
		//cargarListaArriendos();
		//cargarListaAutomoviles();
	}
	// Setters
	public void setListaClientes(ArrayList<Cliente> pListaClientes) {
		this.listaClientes = pListaClientes;
	}
	public void setListaArriendos(ArrayList<ArriendoCuota> pCuotas) {
		this.listaArriendos = pCuotas;
	}
	public void setListaAutomoviles(ArrayList<Automovil> pListaAutomoviles) {
		this.listaAutomoviles = pListaAutomoviles;
	}
	
	// Getters
	public ArrayList<Cliente> getListaClientes() {
		return this.listaClientes;
	}
	
	public ArrayList<ArriendoCuota> getListaArriendos() {
		return this.listaArriendos;
	}
	public ArrayList<Automovil> getListaAutomoviles() {
		return this.listaAutomoviles;
	}
	//Métodos Customer
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> cargarListaClientes() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
			setListaClientes((ArrayList<Cliente>) in.readObject());
		} catch (IOException | ClassNotFoundException e) {
			setListaClientes(new ArrayList<>());
		}
		return listaClientes;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ArriendoCuota> cargarListaArriendos() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("arriendos.dat"))) {
			setListaArriendos((ArrayList<ArriendoCuota>) in.readObject());//listaClientes.setListaClientes() = (ArrayList<Cliente>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			//setListaArriendos(new ArrayList<>()); // Inicializa lista vacía si el archivo no existe
			System.out.println("No se pudo cargar la lista de arriendos. Se inicializa una lista vacía."+e.getMessage());
		}
		return listaArriendos;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Automovil> cargarListaAutomoviles() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("automoviles.dat"))) {
			setListaAutomoviles((ArrayList<Automovil>) in.readObject());
		} catch (IOException | ClassNotFoundException e) {
			setListaAutomoviles(new ArrayList<>());
		}
		return listaAutomoviles;
	}

}
