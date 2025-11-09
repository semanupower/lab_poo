package prac_8;

public class Reservas {
    String nombre;
    String autor;
    Integer miembro_id;

    public String getNombreLibro() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMiembro_id() {
        return miembro_id;
    }

    public void setMiembro_id(Integer miembro_id) {
        this.miembro_id = miembro_id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Reservas(String nombre, String autor, Integer miembro_id) {
        this.nombre = nombre;
        this.autor = autor;
        this.miembro_id = miembro_id;
    }
}
