package controlador;

import vista.Clientes;
import sumativa_4.Cliente;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ControladorVistaAgregarCliente {
	// Atributos
	private Clientes agregarCliente;
	private Cliente cliente;
	private ArrayList<Cliente> listaClientes;
	
	// Constructor
	public ControladorVistaAgregarCliente(Clientes pAgregarCliente) {
		this.agregarCliente = pAgregarCliente;
				
		agregarCliente.getBtnAgregar().addActionListener(e -> {
			String nombre = agregarCliente.getTxtNombre().getText();
			String cedula = agregarCliente.getTxtCedula().getText();
			Cliente cliente = new Cliente(cedula, nombre);
			// llamar al método agregarCliente
			agregarCliente(cliente);
			// Mostrar vista ArriendoConCuotas
					
		});
	
	}
	public void agregarCliente(Cliente cliente) {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes.add(cliente);
		// guardar en el archivo
		try {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"));
		out.writeObject(listaClientes);
		out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
