package prac_8;

public class Reservas {
    String nombre;
    String autor;
    Integer matricula;

    public String getNombreLibro() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Reservas(String nombre, String autor, Integer matricula) {
        this.nombre = nombre;
        this.autor = autor;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
