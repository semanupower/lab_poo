package prac_8;

public class Libro239 implements Comparable<Libro239>{
    private String titulo;
    private String autor;
    private int year;
    boolean reservado;

    public Libro239(String titulo, String autor, int year) {
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {return autor;}
    public int getYear() {return year;}
    public boolean isReservado() {return reservado;}

    public int compareTo(Libro239 o) {
        return this.titulo.compareTo(o.titulo);
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public String toString() {
        return "Libro239{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", year=" + year +
                ", reservado=" + reservado +
                '}';
    }
}
