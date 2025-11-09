package prac_5;
import java.util.ArrayList;

public class CalculadoraGeometrica573 {
    ArrayList<Figura23> figuras;

    public CalculadoraGeometrica573() {
        figuras = new ArrayList<>();
    }

    public void addFigura(double rad) {
        figuras.add(new CirculoG(rad));
    }

    public void addFigura(double base, double altura) {
        figuras.add(new RectanguloG(base, altura));
    }

    public void addFigura(double base, double altura, double lado1, double lado2) {
        figuras.add(new TrianguloG(base, altura, lado1, lado2));
    }

    public void calcularAreas() {
        for (Figura23 f : figuras) {
            System.out.println("Figura: " + f.getName());
            System.out.println("Area: " + f.calcularArea());
            System.out.println("Perimetro: " + f.calcularPerimetro());

            System.out.println("\n");

        }

    }
}
