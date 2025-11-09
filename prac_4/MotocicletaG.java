package prac_4;

public class MotocicletaG extends VehiculoBaseM {
    private double cilindrada;

    public MotocicletaG(String modelo, int year, String marca, String tipoGasolina, double cilindrada) {
        super(modelo, year, marca, tipoGasolina);
        this.cilindrada = cilindrada;
    }

    public double getvelocidadMaxima(){
        return 100.0;
    }

    @Override
    public String toString(){
        return super.toString() + "\nCilindrada: " + this.cilindrada;
    }
}
