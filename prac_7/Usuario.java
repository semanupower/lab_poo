package prac_7;

import prac_7.exceptions.Matricula23InvalidaException;
import prac_7.exceptions.Saldo09InsuficienteException;

public class Usuario {
    String nombre;
    String apellido;
    String matricula;
    double dinero;

    public Usuario() {}
    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}

    public String getMatricula() {
        if (matricula == null || matricula.isEmpty())
        {
            throw new Matricula23InvalidaException("No se ha asignado una matricula.");
        }
        return matricula;
    }

    public void setMatricula(String matricula) {
        try {
            if (matricula == null || matricula.isEmpty())
            {
                throw new Matricula23InvalidaException("La matrícula no puede estar vacía.");
            }
            if (matricula.length() != 7)
                throw new Matricula23InvalidaException("La matrícula debe de tener estrictamente 7 dígitos.");

            this.matricula = matricula;
        } catch (Matricula23InvalidaException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public void depositar(double dinero) {
        this.dinero += dinero;
    }
    public void retirar (double dinero) {
        try
        {
            if (dinero > this.dinero){
                throw new Saldo09InsuficienteException("No tiene suficiente dinero en su cuenta.\nSaldo: " + getDinero());
            }
            this.dinero -= dinero;
        }
        catch (Saldo09InsuficienteException e)
        {
            System.err.println(e.getMessage());
        }
    }
    public double getDinero() {return dinero;}
}
