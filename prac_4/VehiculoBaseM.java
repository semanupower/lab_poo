package prac_4;

public abstract class VehiculoBaseM {
    protected String modelo;
    protected int year;
    protected String marca;
    protected String tipoGasolina;

    public VehiculoBaseM(String modelo, int year, String marca, String tipoGasolina) {
        this.modelo = modelo;
        this.year = year;
        this.marca = marca;
        this.tipoGasolina = tipoGasolina;
    }
    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getYear() {
        return year;
    }

    public String getTipoGasolina() {
        return tipoGasolina;
    }

    public String toString() {
        return "Modelo: " + this.getModelo() + "\nMarca: " +  this.getMarca() + "\nTipo de Gasolina: " + this.getTipoGasolina()
                + "\nAño: " + this.getYear() + "\nVelocidad maxima: " + getvelocidadMaxima();
    }

    public abstract double getvelocidadMaxima();
}

