package prac_10;

public class CuentaBancaria {
    private final int numeroCuenta;
    private double saldo;

    public CuentaBancaria(int numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double monto) {
        saldo += monto;
        System.out.println(Thread.currentThread().getName() +
                " - Depósito EXITOSO: $" + monto +
                " en cuenta " + numeroCuenta +
                " | Nuevo saldo: $" + saldo);
    }

    public synchronized boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            System.out.println(Thread.currentThread().getName() +
                    " - Retiro EXITOSO: $" + monto +
                    " de cuenta " + numeroCuenta +
                    " | Nuevo saldo: $" + saldo);
            return true;
        }
        System.out.println(Thread.currentThread().getName() +
                " - Retiro FALLADO: Fondos insuficientes en cuenta " + numeroCuenta);
        return false;
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

}

