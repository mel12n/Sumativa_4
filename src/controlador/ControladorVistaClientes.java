package controlador;

import vista.Clientes;
import sumativa_4.Cliente;
import sumativa_4.DatoInvalidoException;

<<<<<<< HEAD
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ControladorVistaClientes {
	// Atributos
	private Clientes agregarCliente;
	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	// Constructor
	public ControladorVistaClientes(Clientes pAgregarCliente) {
		this.agregarCliente = pAgregarCliente;
				
		agregarCliente.getBtnAgregar().addActionListener(e -> {
			String nombre = agregarCliente.getTxtNombre().getText();
			String cedula = agregarCliente.getTxtCedula().getText();
			
			try {
				Cliente cliente = new Cliente(cedula, nombre); // ✅ Evita sombra de variable
				agregarCliente(cliente); // ✅ Lo agregamos correctamente
				for (Cliente cli : listaClientes) {
					System.out.println("Cliente: "+ cli);
				}
			} catch (DatoInvalidoException e1) {
				e1.printStackTrace(); // Podrías mostrar un JOptionPane aquí
			}
		});
	}
	
	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente); // ✅ Ahora sí estás usando la lista global
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
			out.writeObject(listaClientes); // ✅ Guarda toda la lista acumulada
		} catch (IOException e) {
			e.printStackTrace();
		}
=======
import java.awt.Window;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class ControladorVistaClientes {
	// Atributos
	private Clientes agregarCliente;
	private ArrayList<Cliente> listaClientes;
	
	// Constructor
	public ControladorVistaClientes(Clientes pAgregarCliente) {
		
		this.agregarCliente = pAgregarCliente;
		cargarListaClientes(); // Carga la lista de clientes al iniciar		
		agregarCliente.getBtnAgregar().addActionListener(e -> {
			String nombre = agregarCliente.getTxtNombre().getText();
			String cedula = agregarCliente.getTxtCedula().getText();
			
			for (Cliente cliente : listaClientes) {
				if (cliente.getCedula().equals(cedula)) {
					Boolean estado = cliente.getVigencia();
					String vigente = String.valueOf(estado);
					agregarCliente.getLblEstado().setText(vigente);
					System.out.println("El cliente ya existe");
					return;
				}
			}

			try {
				Cliente cliente = new Cliente(cedula, nombre);
				agregarCliente(cliente);
				Window window = SwingUtilities.getWindowAncestor(agregarCliente);
			    if (window != null) {
			        window.dispose(); // Cierra la ventana actual
			    }
				for (Cliente cli : listaClientes) {
					System.out.println("Cliente: "+ cli);
				}
			} catch (DatoInvalidoException e1) {
				e1.printStackTrace();
			}
		});
		
	}
	
	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
			out.writeObject(listaClientes); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> cargarListaClientes() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
			listaClientes = (ArrayList<Cliente>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			listaClientes = new ArrayList<>(); // Inicializa lista vacía si el archivo no existe
		}
		return listaClientes;
>>>>>>> branch 'master' of https://github.com/mel12n/Sumativa_4
	}
}
