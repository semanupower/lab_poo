package prac_8;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaM573 biblioteca = new BibliotecaM573();
        int opc;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("================MENU PRINCIPAL================");
            System.out.println("1. Agregar miembro\n2. Agregar libro\n3.Reservar libro\n4.Añadir categoria\n5. Imprimir miembros\n6. Imprimir libros\n7. Imprimir prestamos\n8. Salir");
            switch (opc = input.nextInt()) {
                case 1:
                    input.nextLine();
                    System.out.println("Ingrese el nombre del miembro: ");
                    String nombre = input.nextLine();
                    System.out.println("Ingrese el apellido del miembro: ");
                    String apellido = input.nextLine();
                    System.out.println("Ingrese la matricula del miembro: ");
                    Integer matricula = input.nextInt();
                    input.nextLine();
                    biblioteca.addUsuario(nombre, apellido, matricula);
                    break;

                case 2:
                    input.nextLine();
                    System.out.println("Ingrese el nombre del libro: ");
                    String nombreLibro = input.nextLine();
                    System.out.println("Ingrese el autor del libro: ");
                    String autorLibro = input.nextLine();
                    System.out.println("Ingrese el año de publicacion: ");
                    int year  = input.nextInt();
                    input.nextLine();
                    biblioteca.addLibro(nombreLibro, autorLibro, year);
                    break;

                case 3:
                    input.nextLine();
                    System.out.println("Ingrese el nombre del libro: ");
                    String nombrePrestamo = input.nextLine();
                    System.out.println("Ingrese el autor del libro: ");
                    String autorPrestamo = input.nextLine();
                    input.nextLine();
                    System.out.println("Ingrese la matricula del miembro: ");
                    Integer matriculaPrestamo = input.nextInt();
                    input.nextLine();
                    biblioteca.reservarLibro(nombrePrestamo, autorPrestamo, matriculaPrestamo);
                    break;

                case 4:
                    input.nextLine();
                    System.out.println("Escriba un genero de libros.");
                    String generoLibro = input.nextLine();
                    biblioteca.setCategoriasUnicas(generoLibro);
                    break;

                case 5:
                    biblioteca.printUsuarios();
                    break;

                case 6:
                    biblioteca.printLibros();
                    break;

                case 7:
                    biblioteca.printReservas();
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Escriba una opción correcta.");
                    break;
            }

        } while (opc != 4);
    }
}
