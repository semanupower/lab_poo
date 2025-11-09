package prac_5;
import java.util.Scanner;

public class Main {
     static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CalculadoraGeometrica573 calc = new CalculadoraGeometrica573();
        while(true) {
            System.out.println("Elija la figura: ");
            System.out.println("1. Circulo\n2. Rectangulo\n3. Triangulo\n4. Salir");
            int opc = input.nextInt();

            if (opc == 4) {break;}
            input.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Escriba el radio del circulo: ");
                    double rad = input.nextDouble();
                    input.nextLine();
                    calc.addFigura(rad);
                    break;
                case 2:
                    System.out.println("Escriba la longitud de la base del rectangulo: ");
                    double b = input.nextDouble();
                    input.nextLine();
                    System.out.println("Escriba la longitud de la altura del triangulo: ");
                    double h = input.nextDouble();
                    input.nextLine();
                    calc.addFigura(b, h);
                    break;
                case 3:
                    System.out.println("Escriba la longitud de la base del triangulo: ");
                    double tb = input.nextDouble();
                    input.nextLine();
                    System.out.println("Escriba la longitud de la altura del triangulo: ");
                    double th = input.nextDouble();
                    input.nextLine();
                    System.out.println("Escriba la longitud del lado izquierdo del triangulo: ");
                    double l1 = input.nextDouble();
                    input.nextLine();
                    System.out.println("Escriba la longitud del lado derecho del triangulo: ");
                    double l2 = input.nextDouble();
                    input.nextLine();
                    calc.addFigura(tb, th, l1, l2);
                    break;

                default:
                    System.out.println("Escriba una opcion correcta.");
                    break;
            }
        }

        calc.calcularAreas();
        input.close();
    }
}
