package prac_8;

import java.util.concurrent.atomic.AtomicInteger;

public class Miembro {
    private String nombre;
    private String apellido;
    private static final AtomicInteger id = new AtomicInteger(0);
    private Integer matricula;

    public Miembro(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        id.incrementAndGet();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId() {
        return id.intValue();
    }


    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Miembro{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id=" + id +
                ", matricula=" + matricula +
                '}';
    }
}
