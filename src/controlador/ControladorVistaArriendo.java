package controlador;

import vista.*;
import sumativa_4.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorVistaArriendo {

	private ArriendoCuota arriendoCuota;
    private ArriendoConCuotas vista;
    private ControladorInterfacePrincipal controladorInterfacePrincipal;
    private ControladorVistaClientes controladorVistaClientes;

    public ControladorVistaArriendo(ArriendoConCuotas vista, ControladorInterfacePrincipal controladorInterfacePrincipal) {
        this.vista = vista;
        this.controladorInterfacePrincipal = controladorInterfacePrincipal;
        
        //Botones
        vista.getBtnGuardar().addActionListener(e -> {
			try {
				guardarArriendo();
			} catch (DatoInvalidoException ex) {
				JOptionPane.showMessageDialog(vista, "Error al guardar el arriendo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
        
        vista.getBtnNuevoCliente().addActionListener(e -> {
        	JFrame ventana = new JFrame("Clientes");
            Clientes vistaClientes = new Clientes();
            vistaClientes.crearGUI(ventana);      
            ControladorVistaClientes controlador = new ControladorVistaClientes(vistaClientes, controladorInterfacePrincipal);
            ventana.setLocationRelativeTo(null);
            // Agrega un WindowListener para detectar el cierre
            ventana.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    // Aquí pones lo que quieras hacer al cerrar la ventana
                	cargarDatos();
                }
            });
            cargarDatos();
        });
    
    	vista.getBtnPagar().addActionListener(e -> {
    		if (arriendoCuota != null && !arriendoCuota.getCuotas().isEmpty()) {
    			CuotaArriendo primeraCuota = arriendoCuota.getCuotas().get(0); // primera cuota
    			primeraCuota.setPagada(true); // marcar como pagada
    			mostrarCuotasEnTabla(arriendoCuota); // refrescar la tabla
    		} else {
    			JOptionPane.showMessageDialog(vista, "No hay cuotas disponibles para pagar.");
    		}
    	});
    	
    	vista.getTxtDias().getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { calcularMonto(); }
            public void removeUpdate(DocumentEvent e) { calcularMonto(); }
            public void changedUpdate(DocumentEvent e) { calcularMonto(); }
        });

        vista.getTxtPrecioDia().getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { calcularMonto(); }
            public void removeUpdate(DocumentEvent e) { calcularMonto(); }
            public void changedUpdate(DocumentEvent e) { calcularMonto(); }
        });
        cargarDatos();
        // Cargar clientes y autos en los JComboBox
        
    }
    
    private void guardarArriendo() throws DatoInvalidoException {
        if (vista.getTxtFecha().getText().isEmpty() || 
            vista.getTxtDias().getText().isEmpty() || 
            vista.getTxtPrecioDia().getText().isEmpty()) {
            throw new DatoInvalidoException("Los campos no pueden estar vacíos.");
        }

        String fechaArriendo = vista.getTxtFecha().getText();
        int diasArriendo = Integer.parseInt(vista.getTxtDias().getText());
        int precioPorDia = Integer.parseInt(vista.getTxtPrecioDia().getText());
        int cantidadCuotas = Integer.parseInt(vista.getTxtCuotas().getText());
        int numArriendo = obtenerUltimoIdArriendo();
        String nuevoCliente = (String) vista.getComboClientes().getSelectedItem();
        String nuevoAutomovil = (String) vista.getComboAutos().getSelectedItem();

        Cliente objetoCliente = null;
        for (Cliente cliente : controladorInterfacePrincipal.getListaClientes()) {
            if (cliente.getCedula().equals(nuevoCliente)) {
                objetoCliente = cliente;
                break;
            }
        }

        Automovil objetoAutomovil = null;
        for (Automovil automovil : controladorInterfacePrincipal.getListaAutomoviles()) {
            if (automovil.getPatente().equals(nuevoAutomovil)) {
                objetoAutomovil = automovil;
                break;
            }
        }

        if (objetoCliente == null || objetoAutomovil == null) {
            throw new DatoInvalidoException("Cliente o Automóvil no encontrado.");
        }

        ArriendoCuota nuevoArriendo = new ArriendoCuota(
            numArriendo, fechaArriendo, diasArriendo, objetoCliente, objetoAutomovil, cantidadCuotas
        );

        if (!nuevoArriendo.ingresarArriendoConCuota(precioPorDia, objetoCliente, objetoAutomovil)) {
            throw new DatoInvalidoException("Número de cuota inválido. Debe ser entre 1 y 6.");
        }

        controladorInterfacePrincipal.getListaArriendos().add(nuevoArriendo);
        mostrarCuotasEnTabla(nuevoArriendo);
        this.arriendoCuota = nuevoArriendo;
        
    }

    public void cargarDatos() {
    	vista.getComboClientes().removeAllItems();
        vista.getComboAutos().removeAllItems();
        vista.getComboClientes().addItem("Seleccione CLIENTE");
        vista.getComboAutos().addItem("Seleccione AUTOMÓVIL");
    	for (Cliente cliente : controladorInterfacePrincipal.getListaClientes()) {
    		vista.getComboClientes().addItem(cliente.getCedula());
    	}

    	for (Automovil automovil : controladorInterfacePrincipal.getListaAutomoviles()) {
    		vista.getComboAutos().addItem(automovil.getPatente());
    	}
    }
    private void mostrarCuotasEnTabla(ArriendoCuota arriendo) {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaCuotas().getModel();
        modelo.setRowCount(0); // Limpia la tabla

        for (CuotaArriendo cuota : arriendo.getCuotas()) {
            Object[] fila = {
                cuota.getNumeroCuota(),
                cuota.getValorCuota(),
                cuota.getPagada() ? "Sí" : "No"
            };
            modelo.addRow(fila);
        }
    }
   
    private void calcularMonto() {
        try {
            int dias = Integer.parseInt(vista.getTxtDias().getText());
            int precio = Integer.parseInt(vista.getTxtPrecioDia().getText());
            int monto = dias * precio;
            vista.getTxtMontoTotal().setText(String.valueOf("$" + monto));
        } catch (NumberFormatException e) {
            vista.getTxtMontoTotal().setText("$0"); // limpia si hay datos inválidos
        }
    }
    private int obtenerUltimoIdArriendo() {
		if (controladorInterfacePrincipal.getListaArriendos().isEmpty()) {
			return 1; // Si no hay arriendos, el primer ID es 1
		} else {
			return controladorInterfacePrincipal.getListaArriendos().get(controladorInterfacePrincipal.getListaArriendos().size() - 1).getNumArriendo() + 1;
		}
	}


}


