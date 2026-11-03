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


    //Buscar Contacto:

    public String buscarContacto(String nombre, String apellido){

        for (Contacto contacto: contactos){
            if(contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)){
                return contacto.getTelefono();
            }
        }
        return null;
    }

    //Eliminar contacto
    public void eliminarContacto(Contacto c){

        contactos.remove(c);
    }

    //Modificar Telefono


    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono){

        if(!Contacto.validarTelefono(nuevoTelefono)) return;

        for (Contacto contacto: contactos){
            if(contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)){

                contacto.setTelefono(nuevoTelefono);
                return;
            }
        }

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

