package prac_6;
import prac_6.interfaces.*;

public class DesarrolladorG extends EmpleadoMG implements Bonificable23, Evaluable09, Promovible573{
    private int proyectosCompletados;
    private double bonificacion;

    public DesarrolladorG(String nombre, String apellido, double salario, int proyectosCompletados, double bonificacion) {
        super(nombre, apellido, salario);
        this.proyectosCompletados = proyectosCompletados;
        this.bonificacion = bonificacion;
    }

    @Override
    public double calcularBonificacion() {
        return bonificacion * (0.12 * proyectosCompletados);
    }

    public void aplicarBonificacion(double porcentaje) {
        this.salario += calcularBonificacion() * (porcentaje / 100);
    }

    public double obtenerCalificacion() {
        double califBase = 50;
        califBase += califBase * proyectosCompletados;
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
            salario *= 1.1;
            bonificacion += 600;
        }
        else {
            System.out.println(getNombre() + " " +  getApellido() + "no es aplicable para un aumento.");
        }
    }
    public boolean esPromovible() {
        return obtenerCalificacion() >= 80;
    }



    public void setProyectosCompletados(int proyectosCompletados) {this.proyectosCompletados = proyectosCompletados;}
}
