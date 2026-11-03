import modelo.Agenda;
import modelo.Contacto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Menú temporal por consola para probar el modelo.
        // Se reemplazará cuando estén la vista y el controlador.
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        String opcion = "";

        while (!opcion.equals("0")) {
            System.out.println();
            System.out.println("===== AGENDA =====");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Modificar teléfono");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. ¿Existe contacto?");
            System.out.println("7. Espacios libres / agenda llena");
            System.out.println("8. Validar teléfono");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1": {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    int antes = agenda.espaciosLibres();
                    agenda.añadirContacto(new Contacto(nombre, apellido, telefono));

                    if (agenda.espaciosLibres() < antes) {
                        System.out.println("Contacto añadido.");
                    } else {
                        System.out.println("No se añadió el contacto.");
                    }
                    break;
                }
                case "2": {
                    if (agenda.listarContactos().isEmpty()) {
                        System.out.println("La agenda está vacía.");
                    }
                    for (Contacto c : agenda.listarContactos()) {
                        System.out.println(c);
                    }
                    break;
                }
                case "3": {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    String telefono = agenda.buscarContacto(nombre, apellido);
                    if (telefono == null) {
                        System.out.println("Contacto no encontrado.");
                    } else {
                        System.out.println("Teléfono: " + telefono);
                    }
                    break;
                }
                case "4": {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = sc.nextLine();

                    agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
                    System.out.println("Teléfono actual: " + agenda.buscarContacto(nombre, apellido));
                    break;
                }
                case "5": {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    // El teléfono no importa: equals solo compara nombre y apellido
                    Contacto c = new Contacto(nombre, apellido, "");
                    boolean existia = agenda.existeContacto(c);
                    agenda.eliminarContacto(c);

                    if (existia) {
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Ese contacto no existe.");
                    }
                    break;
                }
                case "6": {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    boolean existe = agenda.existeContacto(new Contacto(nombre, apellido, ""));
                    System.out.println(existe ? "Sí existe." : "No existe.");
                    break;
                }
                case "7": {
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    System.out.println("Agenda llena: " + agenda.agendaLlena());
                    break;
                }
                case "8": {
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.println("Válido: " + Contacto.validarTelefono(telefono));
                    break;
                }
                case "0":
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
