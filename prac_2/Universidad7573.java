package prac_2;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Universidad7573 {
    ArrayList<EstudianteMG> estudiantes;
    Scanner input;

    public Universidad7573() {
        this.estudiantes = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void closeScanner() {
        input.close();
    }

    public void mostrarEstudiantes() {
        for (EstudianteMG estudianteMG : estudiantes) {
            System.out.println("Lista de estudiantes:\n" + estudianteMG.nombre + "\n");
        }
    }

    public void buscarEstudiante (String estudiante)
    {
        ListIterator<EstudianteMG>iterador = this.estudiantes.listIterator();

        System.out.println("Escriba el nombre a buscar: ");
        String nombre = input.nextLine();
        while (iterador.hasNext())
        {
            EstudianteMG temp = iterador.next();
            if (temp.nombre == nombre)
            {
                System.out.println("Alumno encontrado.\n");
            }
            else {
                System.out.println("No ha sido encontrado el alumno.\n");
            }
            break;
        }

    }

    public void agregarEstudiante()
    {
        System.out.println("Escriba el nombre del alumno: ");
        String alumno = input.nextLine();

        System.out.println("Escriba la matricula del alumno: ");
        int matricula = input.nextInt();

        System.out.println("Escriba la edad del alumno: ");
        int edad = input.nextInt();
        input.nextLine();

        System.out.println("Escriba la carrera del alumno: ");
        String carrera = input.nextLine();

        System.out.println("Escriba el semestre del alumno (ej. 1, 2, 3): ");
        int semestre = input.nextInt();
        input.nextLine();
        
        EstudianteMG newEstudiante = new EstudianteMG(matricula, alumno, edad, carrera, semestre);
        this.estudiantes.add(newEstudiante);
    }
}
