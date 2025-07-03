package com.andrew.system_school_control_m.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaTest {
    private Disciplina disciplina;

    @BeforeEach
    void setUp(){
        disciplina = new Disciplina("Matematica");
    }

    @Test
    void calcularCorretamenteMediaFinalAnual(){

        disciplina.getBimestre(1).setNotaProva(8.0);
        disciplina.getBimestre(2).setNotaProva(7.0);
        disciplina.getBimestre(3).setNotaProva(6.0);
        disciplina.getBimestre(4).setNotaProva(10.0);

        double mediaAnualEsperad = 7.75;

        double mediaAnualCalculada = disciplina.calcularMediaFinalAnual();

        assertEquals(mediaAnualCalculada, mediaAnualEsperad, 0.001);
    }

    @Test
    void verificarAprovacaoFinalCorretamente(){

        disciplina.getBimestre(1).setNotaProva(7.0);
        disciplina.getBimestre(2).setNotaProva(7.0);
        disciplina.getBimestre(3).setNotaProva(7.0);
        disciplina.getBimestre(4).setNotaProva(7.0);

        double mediaParaAprovacao = 6.0;

        boolean foiAprovado = disciplina.verificarAprovacaoFinal(mediaParaAprovacao);

        assertTrue(foiAprovado);
    }

    @Test
    void verificarReprovacaoFinalCorretamente() {

        disciplina.getBimestre(1).setNotaProva(6.0);
        disciplina.getBimestre(2).setNotaProva(7.0);
        disciplina.getBimestre(3).setNotaProva(6.5);
        disciplina.getBimestre(4).setNotaProva(7.0);

        double mediaParaAprovacao = 7.0;

        boolean foiAprovado = disciplina.verificarAprovacaoFinal(mediaParaAprovacao);

        assertFalse(foiAprovado);
    }

}