package prac_6;

import prac_6.interfaces.*;

public class VendedorG extends EmpleadoMG implements Bonificable23, Evaluable09, Promovible573 {
    private int ventas;
    private double comision;

    public VendedorG(String nombre, String apellido, double salario, int ventas) {
        super(nombre, apellido, salario);
        this.ventas = ventas;
    }

    @Override
    public double calcularBonificacion() {
        return ventas * (comision / 100);
    }

    @Override
    public void aplicarBonificacion(double porcentaje) {
        salario += salario * (porcentaje/100);
    }

    public double obtenerCalificacion() {
        double califBase = 50;
        if (ventas >= 100)
        {
            califBase += 30;
        }
        else if (ventas >= 50){
            califBase += 20;
        }
        else if (ventas >= 20){
            califBase += 10;
        }
        califBase += calcularBonificacion() * (comision/100);
        return califBase;
    }

    public String evaluacion() {
        double calificacion = obtenerCalificacion();
        if (calificacion >= 90) {
            return "Desempeño excelente.";
        }
        else if(calificacion >= 70) {
            return "Buen desempeño.";
        }
        else {
            return "Necesita mejorar su desempeño.";
        }
    }

    public void promover() {
        if (esPromovible()) {
            salario *= 1.20;
            comision += 15;
        }
    }
    @Override
    public boolean esPromovible() {
        return obtenerCalificacion() >= 80;
    }

    public void registrarVenta(int cantidad) {
        ventas += cantidad;
    }
    public int getVentas() {
        return ventas;
    }
    public double getComision() {return comision/100;}
}
