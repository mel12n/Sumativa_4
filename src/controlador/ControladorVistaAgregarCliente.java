package controlador;

import vista.Clientes;
import sumativa_4.Cliente;
import sumativa_4.DatoInvalidoException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ControladorVistaAgregarCliente {
	// Atributos
	private Clientes agregarCliente;
	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	// Constructor
	public ControladorVistaAgregarCliente(Clientes pAgregarCliente) {
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
	}
}
