package controlador;

import vista.AgregarCliente;
import sumativa_4.Cliente;
import java.util.ArrayList;

public class ControladorVistaAgregarCliente {
	// Atributos
	private AgregarCliente agregarCliente;
	private Cliente cliente;
	private ArrayList<Cliente> listaClientes;
	
	// Constructor
	public ControladorVistaAgregarCliente(AgregarCliente pAgregarCliente) {
		this.agregarCliente = pAgregarCliente;
				
		agregarCliente.getBtnAgregar().addActionListener(e -> {
			String nombre = agregarCliente.getTxtNombre().getText();
			String cedula = agregarCliente.getTxtCedula().getText();
			Cliente cliente = new Cliente(cedula, nombre);
			
		});
	
	}
	public void agregarCliente() {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes.add(cliente);
	}

}
