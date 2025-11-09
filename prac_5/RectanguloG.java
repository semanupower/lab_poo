package prac_5;

public class RectanguloG extends Figura23 {
    public RectanguloG(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    public RectanguloG(int altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    public RectanguloG(int base, int altura) {
        this.altura = altura;
        this.base = base;
    }

    public double calcularPerimetro() {
        return 2*this.altura + 2*this.base;
    }

    @Override
    public String getName() {
        return "Rectangulo";
    }
}
