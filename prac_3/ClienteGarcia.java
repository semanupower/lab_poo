package prac_3;

public class ClienteGarcia {
    protected String nombre;
    protected String apellido;

    public void setNombre(String primNombre) {
        this.nombre = primNombre;
        if (primNombre.isEmpty()) {
            throw new IllegalArgumentException("No se puede dejar un espacio vacío.");
        }

    }

    public void setApellido(String ap) {
        this.apellido = ap;
        if (ap.isEmpty()) {
            throw new IllegalArgumentException("No se puede dejar un espacio vacío.");
        }
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
