package controlador;

import vista.*;
import sumativa_4.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorVistaArriendo {

	private Cliente cliente;
	private ArriendoCuota arriendoCuota;
	private Automovil automovil;
    private ArriendoConCuotas vista;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<ArriendoCuota> listaArriendos;
    private ArrayList<Automovil> listaAutomoviles;
    

    public ControladorVistaArriendo(ArriendoConCuotas vista) {
        this.vista = vista;
        this.listaClientes = new ArrayList<>();
        this.listaArriendos = new ArrayList<>();
        this.listaAutomoviles = new ArrayList<>();

        //Acá cargar clientes, vehiculos y arriendos
        
        //Botones
        vista.getBtnGuardar().addActionListener(e -> {
			try {
				guardarArriendo();
			} catch (DatoInvalidoException ex) {
				JOptionPane.showMessageDialog(vista, "Error al guardar el arriendo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
        
        vista.getBtnNuevoCliente().addActionListener(e -> {
        	JFrame ventana = new JFrame("Agregar Cliente");
	        Clientes vistaClientes = new Clientes();
	        vistaClientes.crearGUI(ventana);
	        ControladorVistaClientes controlador = new ControladorVistaClientes(vistaClientes);
	        ventana.setLocationRelativeTo(null); // Centra la ventana
	        
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
    }

    private void guardarArriendo() throws DatoInvalidoException {
    	if (vista.getTxtFecha().getText().isEmpty() || vista.getTxtDias().getText().isEmpty() || vista.getTxtPrecioDia().getText().isEmpty()) {
			throw new DatoInvalidoException("Los campos no pueden estar vacíos.");
		}
    	String fechaArriendo = vista.getTxtFecha().getText();
    	int diasArriendo = Integer.parseInt(vista.getTxtDias().getText());
    	int precioPorDia = Integer.parseInt(vista.getTxtPrecioDia().getText());
    	int cantidadCuotas = Integer.parseInt(vista.getTxtCuotas().getText());
    	Cliente nuevoCliente = (Cliente) vista.getComboClientes().getSelectedItem();
    	Automovil nuevoAutomovil = (Automovil) vista.getComboAutos().getSelectedItem();
    	ArriendoCuota nuevoArriendo = new ArriendoCuota(1,fechaArriendo,diasArriendo,nuevoCliente,nuevoAutomovil,cantidadCuotas);
    	
    	if (!nuevoArriendo.ingresarArriendoConCuota(precioPorDia, nuevoCliente, nuevoAutomovil)) {
    		throw new DatoInvalidoException("Número de cuota inválido. Debe ser entre 1 y 6.");
    	} 
    	//Aquí se debe agregar el arriendo al arreglo arriendos.
    	mostrarCuotasEnTabla(nuevoArriendo);
    	this.arriendoCuota = nuevoArriendo;
    	 //Esto nos permite guardar el ultimo arriendo que se guardó
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
            vista.getTxtMontoTotal().setText(String.valueOf(monto));
        } catch (NumberFormatException e) {
            vista.getTxtMontoTotal().setText(""); // limpia si hay datos inválidos
        }
    }


}


