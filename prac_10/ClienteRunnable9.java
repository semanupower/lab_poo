package prac_10;

import java.util.List;
import java.util.Random;

public class ClienteRunnable9  implements Runnable {
    private final BancoConcurrenteMG banco;
    private final int idCliente;

    public ClienteRunnable9(BancoConcurrenteMG banco, int idCliente, List<Accion> accionesCliente1) {
        this.banco = banco;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            try {
                int cuentaId = 1 + random.nextInt(10);
                CuentaBancaria cuenta = banco.getCuenta(cuentaId);

                if (cuenta != null) {
                    if (random.nextBoolean()) {
                        double montoDeposito = 50 + random.nextInt(300);
                        cuenta.depositar(montoDeposito);
                        System.out.println(Thread.currentThread().getName() + "Depósito: $" + montoDeposito + "en cuenta " + cuentaId);
                    } else {
                        double montoRetiro = 20 + random.nextInt(200);
                        if (cuenta.retirar(montoRetiro)) {
                            System.out.println(Thread.currentThread().getName() + "Retiro: $" + montoRetiro + "de cuenta " + cuentaId);
                        }
                    }
                }

                Thread.sleep(150 + random.nextInt(300));
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrumpido");
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " ha terminado sus operaciones");
    }

    enum TipoAccion {
        DEPOSITO, RETIRO
    }

    static class Accion {
        final int cuentaId;
        final TipoAccion tipo;
        final double monto;

        Accion(int cuentaId, TipoAccion tipo, double monto) {
            this.cuentaId = cuentaId;
            this.tipo = tipo;
            this.monto = monto;
        }
    }

}
