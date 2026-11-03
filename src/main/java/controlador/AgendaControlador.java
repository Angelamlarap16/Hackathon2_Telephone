package controlador;

import modelo.Agenda;
import modelo.Contacto;
import vista.VentanaPrincipal;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaControlador implements ActionListener, ListSelectionListener {

    private Agenda agenda;
    private VentanaPrincipal vista;

    public AgendaControlador(Agenda agenda, VentanaPrincipal vista) {
        this.agenda = agenda;
        this.vista = vista;

        vista.getBtnAnadir().addActionListener(this);
        vista.getBtnBuscar().addActionListener(this);
        vista.getBtnModificar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getTabla().getSelectionModel().addListSelectionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAnadir()) {
            anadir();
        } else if (e.getSource() == vista.getBtnBuscar()) {
            buscar();
        } else if (e.getSource() == vista.getBtnModificar()) {
            modificar();
        } else if (e.getSource() == vista.getBtnEliminar()) {
            eliminar();
        }
    }

    private void anadir() {
        String nombre = vista.getTxtNombre().getText().trim();
        String apellido = vista.getTxtApellido().getText().trim();
        String telefono = vista.getTxtTelefono().getText().trim();

        Contacto c = new Contacto(nombre, apellido, telefono);

        if (agenda.añadirContacto(c)) {
            vista.mostrarExito("Contacto añadido. Espacios libres: " + agenda.espaciosLibres());
            vista.actualizarTabla(agenda.listarContactos());
            vista.limpiarCampos();
        } else if (!Contacto.validarNombreApellido(nombre, apellido)) {
            vista.mostrarError("El nombre y el apellido son obligatorios");
        } else if (!Contacto.validarTelefono(telefono)) {
            vista.mostrarError("Teléfono inválido. Formatos: +34 600 000 000 o 600000000");
        } else if (agenda.agendaLlena()) {
            vista.mostrarError("La agenda está llena");
        } else {
            vista.mostrarError("El contacto ya existe");
        }
    }

    private void buscar() {
        String nombre = vista.getTxtNombre().getText().trim();
        String apellido = vista.getTxtApellido().getText().trim();

        String telefono = agenda.buscarContacto(nombre, apellido);

        if (telefono == null) {
            vista.mostrarError("Contacto no encontrado");
        } else {
            vista.getTxtTelefono().setText(telefono);
            vista.mostrarExito("Contacto encontrado");
        }
    }

    private void modificar() {
        String nombre = vista.getTxtNombre().getText().trim();
        String apellido = vista.getTxtApellido().getText().trim();
        String telefono = vista.getTxtTelefono().getText().trim();

        if (!Contacto.validarTelefono(telefono)) {
            vista.mostrarError("Teléfono inválido. Formatos: +34 600 000 000 o 600000000");
            return;
        }
        if (agenda.buscarContacto(nombre, apellido) == null) {
            vista.mostrarError("Contacto no encontrado");
            return;
        }

        agenda.modificarTelefono(nombre, apellido, telefono);
        vista.mostrarExito("Teléfono modificado");
        vista.actualizarTabla(agenda.listarContactos());
    }

    private void eliminar() {
        String nombre = vista.getTxtNombre().getText().trim();
        String apellido = vista.getTxtApellido().getText().trim();

        Contacto c = new Contacto(nombre, apellido, "");

        if (!agenda.existeContacto(c)) {
            vista.mostrarError("Contacto no encontrado");
            return;
        }

        agenda.eliminarContacto(c);
        vista.mostrarExito("Contacto eliminado");
        vista.actualizarTabla(agenda.listarContactos());
        vista.limpiarCampos();
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int fila = vista.getTabla().getSelectedRow();
        if (fila == -1) return;

        vista.getTxtNombre().setText(vista.getTabla().getValueAt(fila, 0).toString());
        vista.getTxtApellido().setText(vista.getTabla().getValueAt(fila, 1).toString());
        vista.getTxtTelefono().setText(vista.getTabla().getValueAt(fila, 2).toString());
    }
}