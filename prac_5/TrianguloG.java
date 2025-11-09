package prac_5;

public class TrianguloG extends Figura23 {
    double lado1, lado2;
    public TrianguloG(double base, double altura, double lado1, double lado2) {
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public TrianguloG(double base, double altura, int lado1, int lado2) {
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public TrianguloG(int base, int altura, double lado1, double lado2) {
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + base;
    }

    public double calcularArea() {
        return (altura * base)/2;
    }

    @Override
    public String getName() {
        return "Triangulo";
    }
}
