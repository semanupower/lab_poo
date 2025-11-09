package prac_6;

import prac_6.interfaces.Promovible573;

import java.util.ArrayList;
import java.util.ListIterator;

public class EmpresaTIM573 {
    ArrayList<EmpleadoMG> empleados;
    public EmpresaTIM573() {
        empleados = new ArrayList<>();
    }

    public ArrayList<EmpleadoMG> getEmpleados() {
        return empleados;
    }

    public void buscarEmpleado (String nombre, String apellido)
    {
        ListIterator<EmpleadoMG>iterador = empleados.listIterator();

        while (iterador.hasNext())
        {
            EmpleadoMG sig = iterador.next();
            if (sig.getNombre().equals(nombre) && sig.getApellido().equals(apellido))
            {
                System.out.println("Empleado: " + sig.getNombre()  + " " + sig.getApellido() + " encontrado.");
                return;
            }
        }
        System.out.println("Empleado: " + nombre + " " + apellido + " no encontrado.");
    }

    public void aumentos()
    {
        if (!empleados.listIterator().hasNext())
        {
            System.out.println("No hay empleados.");
            return;
        }

        for (EmpleadoMG empleado : empleados) {
            if (empleado instanceof Promovible573 promo) {
                if (promo.esPromovible()) {
                    promo.promover();
                }
            }
        }
    }

    public void main(String[] args) {
        EmpresaTIM573 empresa = new EmpresaTIM573();
        GerenteG gerente1 = new GerenteG("Adrian", "Garcia", 35000.99, 10, 540.5);
        empresa.empleados.add(gerente1);
        DesarrolladorG desarrollador1 = new DesarrolladorG("Mau", "Perez", 15000, 6, 200);
        empresa.empleados.add(desarrollador1);
        VendedorG vendedor1 = new VendedorG("Manuel", "Torres", 10000, 50);
        empresa.empleados.add(vendedor1);
        empresa.buscarEmpleado("Adrian", "Garcia");

        System.out.println("Aumentos:");
        empresa.aumentos();

    }

}
