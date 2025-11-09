package prac_8;


import java.util.*;

public class BibliotecaM573 {
    private ArrayList<Libro239> libros = new ArrayList<>();
    private LinkedList<Reservas> colaReservas = new LinkedList<>();
    private HashMap<Integer, Miembro> miembros = new HashMap<>();
    private HashSet<String> categoriasUnicas = new HashSet<>();

    public BibliotecaM573() {}

    public void addLibro (String titulo, String autor, String ISBN, String editorial, int year) {
        Libro239 libro = new Libro239(titulo, autor, ISBN, editorial, year);
        libros.add(libro);
        long StartTime = System.currentTimeMillis();
        long StopTime = System.currentTimeMillis();
        long Tiempo = StopTime - StartTime;
        Collections.sort(libros);
        System.out.println("Tiempo en ordenar los libros: " + Tiempo);
    }

    public void addUsuario(String nombre, String apellido, Integer id, Integer matricula) {
        Miembro miembro = new Miembro(nombre, apellido, id, matricula);
        miembros.put(matricula, miembro);
    }

    public HashMap<Integer, Miembro> getMiembros() {
        return miembros;
    }

    public boolean buscarMiembro(int matricula) {
        return miembros.containsKey(matricula);
    }

    public Libro239 buscarLibro(String nombre, String autor) {
        long StartTime = System.currentTimeMillis();
        long StopTime = System.currentTimeMillis();
        long Tiempo = StopTime - StartTime;
        for (Libro239 libro : libros) {
            if (libro.getTitulo().equals(nombre) && libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        System.out.println("Tiempo en buscar el libro: " + Tiempo);
        return null;
    }

    public void printUsuarios() {
        if (miembros.isEmpty()) {
            System.out.println("No hay miembros registrados.");
            return;
        }
        long StartTime = System.currentTimeMillis();
        long StopTime = System.currentTimeMillis();
        long Tiempo = StopTime - StartTime;
        ArrayList<Miembro> miembrosDesordenados = new ArrayList<>(miembros.values());
        miembrosDesordenados.sort(Comparator.comparing(Miembro::getId));
        for (Miembro miembro : miembrosDesordenados) {
            System.out.println(miembro.toString());
        }
        System.out.println("Tiempo en realizar el metodo: " + Tiempo);
    }

    public void reservarLibro(String nombre, String autor, Integer matricula) {
        Libro239 libro = buscarLibro(nombre, autor);
        if (buscarMiembro(matricula) && libro != null) {
            if (!libro.isReservado()) {
                libro.setReservado(true);
                Reservas reservado = new Reservas(nombre, autor, matricula);
                colaReservas.add(reservado);
            }
            else  {
                System.out.println("El libro esta reservado.");
            }
        }
    }

    public void setCategoriasUnicas(String categoria) {
        categoriasUnicas.add(categoria);
    }

}

