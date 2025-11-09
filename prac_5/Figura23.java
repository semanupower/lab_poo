package prac_5;

public abstract class Figura23 implements CalculableM {
    double altura;
    double base;

    public double calcularArea() {
        return altura * base;
    }

    public double getAltura() {
        return altura;
    }

    public double getBase() {
        return base;
    }

}
