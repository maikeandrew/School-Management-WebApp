package com.andrew.system_school_control_m.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BimestreTest {

    @Test
    void deveCalcularNotaBimestralCorretamenteComTrabalhosEProva() {
        Bimestre bimestre = new Bimestre();
        bimestre.adicionarNotaTrabalho(7.0);
        bimestre.adicionarNotaTrabalho(8.0);
        bimestre.setNotaProva(6.0);

        double resultadoEsperado = 7.0;

        double resultadoCalculado = bimestre.calcularNotaBimestre();
        assertEquals(resultadoEsperado, resultadoCalculado, 0.001);
    }

    @Test
    void deveCalcularNotaCorretamenteApenasComProva() {

        Bimestre bimestre = new Bimestre();
        bimestre.setNotaProva(8.0);

        double resultadoEsperado = 8.0;

        double resultadoCalculado = bimestre.calcularNotaBimestre();
        assertEquals(resultadoEsperado, resultadoCalculado, 0.001);
    }
}