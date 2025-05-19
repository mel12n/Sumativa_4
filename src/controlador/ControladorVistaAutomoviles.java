package controlador;

import vista.Automoviles;
import sumativa_4.*;

import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ControladorVistaAutomoviles {
    // Atributos
    private Automoviles agregarAutomovil;
    private ControladorInterfacePrincipal controladorInterfacePrincipal;
    private ArrayList<Automovil> listaAutomoviles;

    // Constructor
    public ControladorVistaAutomoviles(Automoviles pAgregarAutomovil, ControladorInterfacePrincipal pControlador) {
        this.agregarAutomovil = pAgregarAutomovil;
        this.controladorInterfacePrincipal = pControlador;
        this.listaAutomoviles = pControlador.getListaAutomoviles();

        // Acción del botón agregar
        agregarAutomovil.getBtnAgregar().addActionListener(e -> {
            String patente = agregarAutomovil.getTxtPatente().getText();
            String marca = agregarAutomovil.getTxtMarca().getText();
            String modelo = agregarAutomovil.getTxtModelo().getText();
            String anioTexto = agregarAutomovil.getTxtAnio().getText();

            // Verificar si ya existe el automóvil
            for (Automovil auto : listaAutomoviles) {
                if (auto.getPatente().equalsIgnoreCase(patente)) {
                    JOptionPane.showMessageDialog(null, "El automóvil con patente " + patente + " ya existe.",
                            "Automóvil existente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            try {
                int anio = Integer.parseInt(anioTexto);
                Automovil automovil = new Automovil(patente, marca, modelo, anio);
                agregarAutomovil(automovil);
                Window window = SwingUtilities.getWindowAncestor(agregarAutomovil);
                if (window != null) {
                    window.dispose();
                }
                for (Automovil auto : listaAutomoviles) {
                    System.out.println("Automóvil: " + auto); // Para depuración
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(agregarAutomovil,
                    "El año debe ser un número entero.",
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
            } catch (DatoInvalidoException e1) {
                JOptionPane.showMessageDialog(agregarAutomovil,
                    e1.getMessage(),
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void agregarAutomovil(Automovil automovil) {
        listaAutomoviles.add(automovil);
        GuardarDocumento guardarDocumento = new GuardarDocumento(null, null, null);
        guardarDocumento.guardarAutomovil(listaAutomoviles);
    }
}

