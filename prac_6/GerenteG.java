package prac_6;
import prac_6.interfaces.*;
public class GerenteG extends EmpleadoMG implements Bonificable23, Evaluable09, Promovible573 {
    private int empleadosaCargo;
    private double bonificacion;

    public GerenteG(String nombre, String apellido, double salario, int empleadosaCargo, double bonificacion) {
        super(nombre, apellido, salario);
        this.empleadosaCargo = empleadosaCargo;
        this.bonificacion = bonificacion;
    }

    public double calcularBonificacion() {
        return bonificacion * (0.2 * empleadosaCargo * getSalario());
    }
    public void aplicarBonificacion(double porcentaje) {
        this.salario += calcularBonificacion() * (porcentaje / 100);
    }

    public double obtenerCalificacion() {
        double califBase = 50;
        califBase += califBase * empleadosaCargo;
        califBase += califBase * bonificacion;
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
            System.out.println(getNombre() + " " +  getApellido() + "es aplicable.\nSalario anterior: " + getSalario());
            salario *= 1.20;
            bonificacion += 600;
            System.out.println("Salario nuevo: " +  getSalario() + "\nBonificacion nueva: " + bonificacion);
        }
    }

    @Override
    public boolean esPromovible() {
        return obtenerCalificacion() >= 80;
    }

    public int getEmpleadosaCargo() {
        return empleadosaCargo;
    }
    public void setEmpleadosaCargo(int empleados) {empleadosaCargo=empleados;}
}
