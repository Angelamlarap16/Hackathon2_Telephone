package modelo;

import java.util.ArrayList;
import java.util.Collections;
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

    public void añadirContacto (Contacto c) {
        if ( !agendaLlena( )) {
            contactos.add(c);
        }
    }
    public boolean existeContacto (Contacto c) {
        return contactos.contains(c);
    }

    public List<Contacto> listarContactos() {
        contactos.sort(Comparator.comparing(Contacto::getNombre));
      return contactos;
    }
}

