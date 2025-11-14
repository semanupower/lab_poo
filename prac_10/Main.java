package prac_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== SISTEMA BANCARIO CONCURRENTE COMPLETO ===");

        // 1. Demo del sistema bancario
        demoBancoConcurrente();

        // 2. Demo Productor-Consumidor
        demoProductorConsumidor();

        // 3. Demo ThreadPool personalizado vs ExecutorService
        demoThreadPools();

        // 4. Análisis de rendimiento
        analisisRendimiento();

        System.out.println("=== PROGRAMA TERMINADO ===");
    }

    private static void demoBancoConcurrente() throws InterruptedException {
        System.out.println("\n--- DEMOSTRACIÓN SISTEMA BANCARIO ---");
        BancoConcurrenteMG banco = new BancoConcurrenteMG();
        banco.mostrarSaldos();

        // Definir operaciones fijas para cajeros
        List<CajeroThread23.Operacion> operacionesCajero1 = Arrays.asList(
                new CajeroThread23().Operacion(1, 2, 100.0),
                new CajeroThread23().Operacion(3, 4, 200.0),
                new CajeroThread23().Operacion(2, 5, 150.0)
        );

        List<CajeroThread23.Operacion> operacionesCajero2 = Arrays.asList(
                new CajeroThread23().Operacion(4, 1, 300.0),
                new CajeroThread23().Operacion(5, 3, 100.0),
                new CajeroThread23().Operacion(1, 4, 250.0)
        );

        // Crear cajeros (threads)
        CajeroThread23 cajero1 = new CajeroThread23(banco, 1, operacionesCajero1);
        CajeroThread23 cajero2 = new CajeroThread23(banco, 2, operacionesCajero2);

        // Definir acciones fijas para clientes
        List<ClienteRunnable9.Accion> accionesCliente1 = Arrays.asList(
                new ClienteRunnable9().Accion(1, ClienteRunnable9.TipoAccion.DEPOSITO, 500.0),
                new ClienteRunnable9().Accion(1, ClienteRunnable9.TipoAccion.RETIRO, 200.0)
        );

        List<ClienteRunnable9.Accion> accionesCliente2 = Arrays.asList(
                new ClienteRunnable9.Accion(2, ClienteRunnable9.TipoAccion.DEPOSITO, 300.0),
                new ClienteRunnable9.Accion(3, ClienteRunnable9.TipoAccion.RETIRO, 100.0)
        );

        // Crear clientes (runnables)
        Thread cliente1 = new Thread(new ClienteRunnable9(banco, 1, accionesCliente1), "Cliente-1");
        Thread cliente2 = new Thread(new ClienteRunnable9(banco, 2, accionesCliente2), "Cliente-2");

        // Iniciar todos los hilos
        cajero1.start();
        cajero2.start();
        cliente1.start();
        cliente2.start();

        // Esperar a que terminen
        cajero1.join();
        cajero2.join();
        cliente1.join();
        cliente2.join();

        banco.mostrarSaldos();
    }

    private static void demoProductorConsumidor() throws InterruptedException {
        System.out.println("\n--- DEMOSTRACIÓN PRODUCTOR-CONSUMIDOR ---");
        BufferCompartido73 buffer = new BufferCompartido73();

        // Valores fijos para producción
        int[] valoresProductor1 = {10, 20, 30, 40, 50};
        int[] valoresProductor2 = {15, 25, 35, 45, 55};

        // Crear productores y consumidores
        Thread productor1 = new Thread(new Productor(buffer, 1, valoresProductor1), "Productor-1");
        Thread productor2 = new Thread(new Productor(buffer, 2, valoresProductor2), "Productor-2");
        Thread consumidor1 = new Thread(new Consumidor(buffer, 1), "Consumidor-1");
        Thread consumidor2 = new Thread(new Consumidor(buffer, 2), "Consumidor-2");

        // Iniciar hilos
        productor1.start();
        productor2.start();
        consumidor1.start();
        consumidor2.start();

        // Esperar a que terminen
        productor1.join();
        productor2.join();
        consumidor1.join();
        consumidor2.join();

        System.out.println("📊 Total elementos producidos: " + buffer.getContadorProduccion());
    }

    private static void demoThreadPools() throws InterruptedException {
        System.out.println("\n--- DEMOSTRACIÓN THREAD POOLS ---");

        // ThreadPool personalizado
        System.out.println("🔄 Usando ThreadPoolGarcia personalizado:");
        ThreadPoolGarcia poolPersonalizado = new ThreadPoolGarcia(2);

        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            poolPersonalizado.execute(() -> {
                System.out.println(Thread.currentThread().getName() +
                        " ejecutando tarea " + taskId);
                try {
                    Thread.sleep(200); // Tiempo fijo de procesamiento
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        Thread.sleep(1000);
        poolPersonalizado.shutdown();
        poolPersonalizado.awaitTermination(2, TimeUnit.SECONDS);

        // ExecutorService de Java
        System.out.println("\n🔄 Usando ExecutorService estándar:");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Future<?>> futures = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            Future<?> future = executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() +
                        " ejecutando tarea " + taskId);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            futures.add(future);
        }

        // Esperar a que todas las tareas terminen
        for (Future<?> future : futures) {
            future.get();
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }

    private static void analisisRendimiento() {
        System.out.println("\n--- ANÁLISIS DE RENDIMIENTO ---");

        // Comparación de diferentes estrategias de sincronización
        int iteraciones = 1000;

        // Synchronized tradicional
        long startTime = System.currentTimeMillis();
        ejecutarPruebaSincronizada(iteraciones);
        long syncTime = System.currentTimeMillis() - startTime;

        // ReentrantLock
        startTime = System.currentTimeMillis();
        ejecutarPruebaReentrantLock(iteraciones);
        long lockTime = System.currentTimeMillis() - startTime;

        System.out.println("📈 RESULTADOS DE RENDIMIENTO:");
        System.out.println("⏱️  Tiempo synchronized: " + syncTime + "ms");
        System.out.println("⏱️  Tiempo ReentrantLock: " + lockTime + "ms");
        System.out.println("📊 Diferencia: " + (syncTime - lockTime) + "ms");

        if (syncTime < lockTime) {
            System.out.println("✅ synchronized fue más rápido");
        } else if (lockTime < syncTime) {
            System.out.println("✅ ReentrantLock fue más rápido");
        } else {
            System.out.println("⚖️  Ambos métodos tienen el mismo rendimiento");
        }
    }

    private static void ejecutarPruebaSincronizada(int iteraciones) {
        Object lock = new Object();
        AtomicInteger contador = new AtomicInteger();

        List<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            hilos.add(new Thread(() -> {
                for (int j = 0; j < iteraciones / 4; j++) {
                    synchronized (lock) {
                        contador.incrementAndGet();
                    }
                }
            }));
        }

        hilos.forEach(Thread::start);
        hilos.forEach(hilo -> {
            try { hilo.join(); } catch (InterruptedException e) {}
        });
    }

    private static void ejecutarPruebaReentrantLock(int iteraciones) {
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger contador = new AtomicInteger();

        List<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            hilos.add(new Thread(() -> {
                for (int j = 0; j < iteraciones / 4; j++) {
                    lock.lock();
                    try {
                        contador.incrementAndGet();
                    } finally {
                        lock.unlock();
                    }
                }
            }));
        }

        hilos.forEach(Thread::start);
        hilos.forEach(hilo -> {
            try { hilo.join(); } catch (InterruptedException e) {}
        });
    }

}
