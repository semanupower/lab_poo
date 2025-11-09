package prac_4;

public class CamionG extends VehiculoBaseM {
    private double capacidadCargamento;

    public CamionG(String modelo, int year, String marca, String tipoGasolina, double capacidadCargamento){
        super(modelo, year, marca, tipoGasolina);
        this.capacidadCargamento = capacidadCargamento;
    }

    public double getcapacidadCargamento() {
        return capacidadCargamento;
    }

    public double getvelocidadMaxima() {
        return 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCapacidad de Cargamento: " + getcapacidadCargamento();
    }
}
