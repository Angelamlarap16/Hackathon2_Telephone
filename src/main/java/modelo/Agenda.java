package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agenda {

    // Atributos:
    private List<Contacto> contactos;
    private int capacidadMaxima;

    // constructor
    public Agenda() {
        this.contactos = new ArrayList<>();
        this.capacidadMaxima = 10;
    }

    public Agenda(int capacidadMaxima) {
        this.contactos = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    // Métodos agendaLlena() y espaciosLibres()
    public boolean agendaLlena(){
        return this.contactos.size() >= this.capacidadMaxima;
    }

    public int espaciosLibres(){
        return this.capacidadMaxima - this.contactos.size();
    }


    public boolean añadirContacto(Contacto c) {
        if (!agendaLlena()
                && !existeContacto(c)
                && !c.getNombre().isBlank()
                && !c.getApellido().isBlank()) {
            contactos.add(c);
            return true;
        }
        return false;
    }

    public boolean existeContacto (Contacto c) {
        return contactos.contains(c);
    }

    public List<Contacto> listarContactos() {
        List<Contacto> ordenada = new ArrayList<>(contactos);
        ordenada.sort(Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER));
        return ordenada;
    }
}

