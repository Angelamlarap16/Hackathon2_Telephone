package modelo;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public void validarNombreApellido(String nombre, String apellido) {
        if (nombre == null || nombre.isBlank()) {
            System.out.println("No puede estar vacio el nombre");
            return;
        }
        if (apellido == null || apellido.isBlank()) {
            System.out.println("No puede estar vacio el apellido");
            return;
        }
    }

//Validación de Telefono con Regex
    public static boolean validarTelefono(String telefono){
        if (telefono == null) return false; //Si viene un número vacio / null, retorna falso

        //validos: +34 600 000 000 o 600000000
        String regex1 = "^\\+\\d{2} \\d{3} \\d{3} \\d{3}$";
        String regex2 = "^\\d{9}$";
       // boolean esValidoDirecto = telefono.matches(regex1)|| telefono.matches(regex2);

//        if (!esValidoDirecto) {
//           //System.out.println("el número es inválido estructura válida: validos: +34 600 000 000 o 600000000");
//           return esValidoDirecto;
//       }

        return telefono.matches(regex1)|| telefono.matches(regex2);

    }
//Validar con equals que los contactos no pueden repetirse

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return nombre.equalsIgnoreCase(contacto.nombre) && apellido.equalsIgnoreCase(contacto.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());    }


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
