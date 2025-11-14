package prac_11;

import java.util.Objects;

public class Estudiante {
    private String matricula;
    private String nombre;
    private String apellido;
    private String carrera;

    public Estudiante(String matricula, String nombre, String apellido, String carrera) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }

    public String getMatricula() { return matricula; }

    public void setMatricula(String matricula) {
        if (matricula == null || !matricula.matches("\\d{8}")) {
            throw new IllegalArgumentException("La matrícula debe tener exactamente 8 dígitos");
        }
        this.matricula = matricula;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        this.apellido = apellido.trim();
    }

    public String getCarrera() { return carrera; }

    public void setCarrera(String carrera) {
        if (carrera == null || carrera.trim().isEmpty()) {
            throw new IllegalArgumentException("La carrera es obligatoria");
        }
        this.carrera = carrera.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(matricula, that.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", nombre, apellido, matricula);
    }


}
