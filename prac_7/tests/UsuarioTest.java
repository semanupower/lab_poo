package prac_7.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prac_3.CuentaBancaria2309;
import prac_7.Usuario;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    Usuario cuenta;
    @BeforeEach
    void setUp() {
        cuenta = new Usuario();
    }

    @Test
    public void nombres(){
        cuenta.setNombre("Manuel");
        cuenta.setApellido("Garcia");
        cuenta.setMatricula("2177573");
        assertEquals("Manuel", cuenta.getNombre());
        assertEquals("2177573", cuenta.getMatricula());
    }
}
