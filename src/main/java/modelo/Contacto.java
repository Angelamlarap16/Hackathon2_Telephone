package modelo;

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
