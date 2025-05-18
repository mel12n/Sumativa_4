package sumativa_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class AbrirDocumento {
	// Atributos
	
	private ArrayList<Cliente> listaClientes;
	private ArrayList<CuotaArriendo> listaCuotas; // en que casos es Final?
	
	// Constructor
	
	public AbrirDocumento(ArrayList<Cliente> pListaClientes, ArrayList<CuotaArriendo> pCuotas) {
		
		this.listaClientes = pListaClientes;
		this.listaCuotas = pCuotas;
		
	}
	
	public void setListaClientes(ArrayList<Cliente> pListaClientes) {
		this.listaClientes = pListaClientes;
	}
	public void setCuotas(ArrayList<CuotaArriendo> pCuotas) {
		this.listaCuotas = pCuotas;
	}
	
	public ArrayList<Cliente> getListaClientes() {
		return this.listaClientes;
	}
	
	public ArrayList<CuotaArriendo> getCuotas() {
		return this.listaCuotas;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> cargarListaClientes() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
			setListaClientes((ArrayList<Cliente>) in.readObject());
		} catch (IOException | ClassNotFoundException e) {
			listaClientes = new ArrayList<>(); // Inicializa lista vacía si el archivo no existe
		}
		return listaClientes;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<CuotaArriendo> cargarListaCuotas() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cuotas.dat"))) {
			setCuotas((ArrayList<CuotaArriendo>) in.readObject());//listaClientes.setListaClientes() = (ArrayList<Cliente>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			listaCuotas = new ArrayList<>(); // Inicializa lista vacía si el archivo no existe
		}
		return listaCuotas;
	}

}
