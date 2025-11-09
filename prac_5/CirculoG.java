package prac_5;

//No creo que esta clase ocupe sobrecargas, ya que la unica variable del circulo es el radio
public class CirculoG extends Figura23 {
    double radio;
    double theta;

    public CirculoG(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * this.radio * this.radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * this.radio;
    }

    public double getRadio() {
        return radio;
    }


    public String getName() {
        return "Circulo";
    }
}
