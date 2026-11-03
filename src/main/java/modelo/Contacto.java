package modelo;

import java.util.Objects;

public class Contacto {

    // atributos privados de la clase contacto

    private String nombre;
    private String apellido;
    private String telefono;

    // constructor que recibe todos los atributos de la clase Contacto

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
//Validación de nombres y apellidos obligatorios

    private void ValidarNombreApellido(String nombre, String apellido) {
        if (nombre == null || nombre.isBlank()) {
            system.out.println("No puede estar vacio el nombre")
            return;
        }
        if (apellido == null || apellido.isBlank()) {
            system.out.println("No puede estar vacio el apellido")
            return;
        }
    }

//Validación de Telefono con Regex
    private void ValidarTelefono(String telefono){
        //validos: +34 600 000 000 o 600000000
        String regex1 = "^+\\d{2} \\d{3} \\d{3} \\d{3}$";
        String regex2 = "^\\d{9}$";
        boolean esValidoDirecto = telefono.matches(regex1)|| telefono.matches(regex2);
       if (!esValidoDirecto) {
           system.out.println("el número es inválido estructura válida: validos: +34 600 000 000 o 600000000")
           return;
       }
    }
//Validar con equals que los contactos no pueden repetirse

    @Override
    public boolean equals(Contacto o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = o;
        return Objects.equals(nombre, contacto.nombre) && Objects.equals(apellido, contacto.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }



    // getters

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    // setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {

        return String.format("Nombre: " + nombre + ", Apellido: " + apellido + ", Telefono: " + telefono);
    }
}
