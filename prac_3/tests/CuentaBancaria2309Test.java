package prac_3.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prac_3.CuentaBancaria2309;

import static org.junit.jupiter.api.Assertions.*;

class CuentaBancaria2309Test {

    CuentaBancaria2309 cuenta;
    @BeforeEach
    void setUp() {
        cuenta = new CuentaBancaria2309();
    }

    @Test
    void setNumeroCuenta() {
        cuenta.setNumeroCuenta("12345");
        assertEquals("12345", cuenta.getNumeroCuenta());
    }

    @Test
    void depositar() {
        cuenta.depositar(5);
        assertEquals(5, cuenta.getDinero());
    }
    @Test
    void retirar() {
        cuenta.depositar(500);
        cuenta.retirar(400);
        assertEquals(100, cuenta.getDinero());

    }
}