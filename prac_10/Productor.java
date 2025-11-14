package prac_10;

import java.util.LinkedList;
import java.util.Queue;

public class Productor implements Runnable {
    private final BufferCompartido73 buffer;
    private final int id;
    private final int[] valores;

    public Productor(BufferCompartido73 buffer, int id, int[] valores) {
        this.buffer = buffer;
        this.id = id;
        this.valores = valores;
    }

    @Override
    public void run() {
        try {
            for (int valor : valores) {
                buffer.producir(valor, "Productor-" + id);
                Thread.sleep(100);
            }
            System.out.println("Productor-" + id + " terminó de producir");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
