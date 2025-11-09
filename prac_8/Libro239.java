package prac_8;

public class Libro239 implements Comparable<Libro239>{
    private String titulo;
    private String autor;
    private String ISBN;
    private String editorial;
    private int year;
    boolean reservado;

    public Libro239(String titulo, String autor, String ISBN, String editorial, int year) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.editorial = editorial;
        this.year = year;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {return autor;}
    public String getISBN() {return ISBN;}
    public String getEditorial() {return editorial;}
    public int getYear() {return year;}
    public boolean isReservado() {return reservado;}

    public int compareTo(Libro239 o) {
        return this.titulo.compareTo(o.titulo);
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}
