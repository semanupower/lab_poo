package prac_4;

public class AutoG extends VehiculoBaseM {
    int numeroAsientos;

    public AutoG(String modelo, int year, String marca, String tipoGasolina, int numeroAsientos) {
        super(modelo, year, marca, tipoGasolina);
        this.numeroAsientos = numeroAsientos;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }
    public double getvelocidadMaxima(){
        return 150.0;
    }

    @Override
    public String toString() {
        return super.toString() + " ";
    }
}
