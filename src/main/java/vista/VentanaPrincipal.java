package vista;

import modelo.Contacto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;

    private DefaultTableModel modeloTabla;
    private JTable tabla;

    private JButton btnAnadir;
    private JButton btnBuscar;
    private JButton btnModificar;
    private JButton btnEliminar;

    private JLabel lblEstado;
    public VentanaPrincipal() {
        setTitle("Agenda Telefónica");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

// paso 3
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtTelefono = new JTextField();
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Apellido:"));
        panelFormulario.add(txtApellido);
        panelFormulario.add(new JLabel("Teléfono:"));
        panelFormulario.add(txtTelefono);
        add(panelFormulario, BorderLayout.NORTH);

//paso 4
        String[] columnas = {"Nombre", "Apellido", "Teléfono"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);


        //paso 5

        JPanel panelBotones = new JPanel();
        btnAnadir = new JButton("Añadir");
        btnBuscar = new JButton("Buscar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        panelBotones.add(btnAnadir);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);

        lblEstado = new JLabel(" ");

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(panelBotones, BorderLayout.NORTH);
        panelInferior.add(lblEstado, BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);


    }

    //paso 6
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtApellido() { return txtApellido; }
    public JTextField getTxtTelefono() { return txtTelefono; }
    public JTable getTabla() { return tabla; }
    public JButton getBtnAnadir() { return btnAnadir; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnModificar() { return btnModificar; }
    public JButton getBtnEliminar() { return btnEliminar; }

//paso 7

    public void actualizarTabla(List<Contacto> lista) {
        modeloTabla.setRowCount(0);
        for (Contacto c : lista) {
            modeloTabla.addRow(new Object[]{c.getNombre(), c.getApellido(), c.getTelefono()});
        }
    }

    public void mostrarExito(String mensaje) {
        lblEstado.setForeground(new Color(0, 128, 0));
        lblEstado.setText(mensaje);
    }

    public void mostrarError(String mensaje) {
        lblEstado.setForeground(Color.RED);
        lblEstado.setText(mensaje);
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
    }

    // paos 8
}