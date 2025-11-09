package prac_8;

public class Miembro {
    private String nombre;
    private String apellido;
    private Integer id;
    private Integer matricula;

    public Miembro(String nombre, String apellido, Integer id, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.matricula = matricula;
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
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
