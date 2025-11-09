package prac_3;

public class CuentaBancaria2309 {
    private double dinero = 0;
    private String numeroCuenta;
    public ClienteGarcia clienteGarcia;

    public CuentaBancaria2309 () {
        this.clienteGarcia = new ClienteGarcia();
    }

    public void setNumeroCuenta(String num) {
        this.numeroCuenta = num;
    }
    public String getNumeroCuenta() {return this.numeroCuenta;}

    public void depositar(double dinero) {
        this.dinero += dinero;
    }

    public void retirar(double dinero) {
        if (dinero > this.dinero) {
            throw new IllegalArgumentException("Escriba una cantidad de dinero válida.");
        }
        this.dinero -= dinero;
    }

    public double getDinero() {
        return this.dinero;
    }

    public String toString() {
        return "\nNumero de cuenta: " + this.numeroCuenta + "\nSaldo disponible: " + this.dinero;
    }
}