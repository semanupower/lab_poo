package prac_7.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prac_7.SistemaBancoMG;
import prac_7.Usuario;

import static org.junit.jupiter.api.Assertions.*;

class SistemaBancoMGTest {
    SistemaBancoMG sistemaBancoMG;

    @BeforeEach
    void setUp() {
        sistemaBancoMG = new SistemaBancoMG();
    }

    @Test
    void buscarUsuarios() {
        sistemaBancoMG.addUsuario("Manuel", "Garcia", "2177573", 500);
        assertEquals("2177573", sistemaBancoMG.getUsuarios().getFirst().getMatricula());
    }
}