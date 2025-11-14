package prac_10;

public class Consumidor implements Runnable{
    private final BufferCompartido73 buffer;
    private final int id;
    private int totalConsumido = 0;

    public Consumidor(BufferCompartido73 buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) { // Cada consumidor procesa 5 elementos
                int valor = buffer.consumir("Consumidor-" + id);
                totalConsumido += valor;
                Thread.sleep(150); // Tiempo fijo entre consumos
            }
            System.out.println("Consumidor-" + id + " terminó | Total consumido: " + totalConsumido);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
