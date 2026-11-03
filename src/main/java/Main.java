import controlador.AgendaControlador;
import modelo.Agenda;
import vista.VentanaPrincipal;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Agenda agenda = new Agenda();
                VentanaPrincipal vista = new VentanaPrincipal();
                new AgendaControlador(agenda, vista);
                vista.setVisible(true);
            }
        });
    }
}