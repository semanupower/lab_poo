package prac_10;

import java.util.LinkedList;
import java.util.Queue;

public class BufferCompartido73 {
    private final Queue<Integer> buffer;
    private final int capacidad;
    private final Object lock = new Object();

    public BufferCompartido73() {
        this.capacidad = 7; // Primer dígito
        this.buffer = new LinkedList<>();
    }

    public void producir(int valor, String productorName) throws InterruptedException {
        synchronized (lock) {
            while (buffer.size() == capacidad) {
                System.out.println(productorName + " esperando - Buffer lleno");
                lock.wait();
            }

            buffer.offer(valor);
            System.out.println(productorName + " produjo: " + valor +
                    " | Buffer size: " + buffer.size());
            lock.notifyAll();
        }
    }

    public int consumir(String consumidorName) throws InterruptedException {
        synchronized (lock) {
            while (buffer.isEmpty()) {
                System.out.println(consumidorName + " esperando - Buffer vacío");
                lock.wait();
            }

            int valor = buffer.poll();
            System.out.println(consumidorName + " consumió: " + valor +
                    " | Buffer size: " + buffer.size());
            lock.notifyAll();
            return valor;
        }
    }
}
