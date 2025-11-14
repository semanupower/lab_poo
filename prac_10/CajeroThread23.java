package prac_10;

import java.util.List;

public class CajeroThread23 extends Thread {
    private final BancoConcurrenteMG banco;
    private final int idCajero;
    private final List<Operacion> operaciones;

    public CajeroThread23(BancoConcurrenteMG banco, int idCajero, List<Operacion> operaciones) {
        super("Cajero-" + idCajero);
        this.banco = banco;
        this.idCajero = idCajero;
        this.operaciones = operaciones;
    }

    @Override
    public void run() {
        System.out.println(getName() + " iniciando operaciones...");

        for (Operacion op : operaciones) {
            try {
                banco.transferencia(op.desde, op.hacia, op.monto);
                Thread.sleep(200); // Tiempo fijo entre operaciones
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrumpido durante operación");
                break;
            }
        }

        System.out.println(getName() + " ha terminado sus operaciones");
    }

    // Clase interna para definir operaciones
    static class Operacion {
        final int desde;
        final int hacia;
        final double monto;

        Operacion(int desde, int hacia, double monto) {
            this.desde = desde;
            this.hacia = hacia;
            this.monto = monto;
        }
    }

}
