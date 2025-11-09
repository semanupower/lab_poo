package prac_6;

public abstract class EmpleadoMG {
    protected String nombre;
    protected String apellido;
    protected double salario;

    public EmpleadoMG(String nombre, String apellido, double salario) {
        if (nombre.isEmpty() || apellido.isEmpty() || salario <= 0) {
            throw new IllegalArgumentException("Escriba opciones válidas.");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {return apellido;}
    public double getSalario() {return salario;}
    private void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salario negativo.");
        }
        this.salario = salario;
    }
}
