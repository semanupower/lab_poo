package prac_2;
import java.util.Scanner;

public class programa {
    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);
        Universidad7573 universidad = new Universidad7573();
        int opc;

        do {
            System.out.println("=================MENU=================\n");
            System.out.println("1. Añadir estudiantes\n2. Buscar estudiantes\n3. Mostrar estudiantes\n4. Salir");
            opc = myScanner.nextInt();

            switch (opc) {
                case 1:
                    universidad.agregarEstudiante();
                    break;
                
                case 2:
                    System.out.println("Escriba el nombre del estudiante: ");
                    String buscarEst = myScanner.nextLine();
                    universidad.buscarEstudiante(buscarEst);
                    break;

                case 3:
                    universidad.mostrarEstudiantes();
                    break;
                
                case 4:
                    System.out.println("Saliendo...");
                    break;
            
                default:
                    System.out.println("Escriba una opción correcta.\n");
                    break;       
            }
            
        } while (opc != 4);

        myScanner.close();
        universidad.closeScanner();
    }
}
