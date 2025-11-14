package prac_10;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class BancoConcurrenteMG {
    private final Map<Integer, CuentaBancaria> cuentas;
    private final Random random;

    public BancoConcurrenteMG() {
        this.cuentas = new ConcurrentHashMap<>();
        this.random = new Random();
        // Inicializar algunas cuentas de ejemplo
        for (int i = 1; i <= 10; i++) {
            cuentas.put(i, new CuentaBancaria(i, 1000 + random.nextInt(5000)));
        }
    }

    public CuentaBancaria getCuenta(int numeroCuenta) {
        return cuentas.get(numeroCuenta);
    }

    public void transferencia(int desde, int hacia, double monto) {
        if (desde == hacia) return;

        CuentaBancaria cuenta1 = cuentas.get(desde);
        CuentaBancaria cuenta2 = cuentas.get(hacia);

        if (cuenta1 == null || cuenta2 == null) return;

        // Ordenar los locks para evitar deadlocks
        CuentaBancaria primera = desde < hacia ? cuenta1 : cuenta2;
        CuentaBancaria segunda = desde < hacia ? cuenta2 : cuenta1;

        synchronized (primera) {
            synchronized (segunda) {
                if (cuenta1.retirar(monto)) {
                    cuenta2.depositar(monto);
                    System.out.println(Thread.currentThread().getName() + "Transferencia: $" + monto + " de " + desde + " a " + hacia);
                }
            }
        }
    }

    public void mostrarSaldos() {
        System.out.println("\n=== SALDOS ACTUALES DE CUENTAS ===");
        for (CuentaBancaria cuenta : cuentas.values()) {
            System.out.println("Cuenta " + cuenta.getNumeroCuenta() + ": $" + cuenta.getSaldo());
        }
        System.out.println("==================================\n");
    }
}
