package com.andrew.system_school_control_m.model;


import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    private final String nome;
    private final List<Bimestre> bimestres;

    public Disciplina(String nome) {
        this.nome = nome;
        this.bimestres = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            this.bimestres.add(new Bimestre());
        }
    }

    public double calcularMediaFinalAnual() {
        double somaDasNotasDosBimestres = 0.0;
        for (Bimestre bimestre : this.bimestres) {
            somaDasNotasDosBimestres += bimestre.calcularNotaBimestre();
        }
        return somaDasNotasDosBimestres / 4.0;
    }

    public boolean verificarAprovacaoFinal(double mediaParaAprovar) {
        return calcularMediaFinalAnual() >= mediaParaAprovar;
    }


    // Getters
    public String getNome() {
        return nome;
    }

    /**
     * Retorna um objeto Bimestre específico.
     *
     * @param numeroBimestre O número do bimestre (de 1 a 4).
     * @return O objeto Bimestre correspondente, ou null se o número for inválido.
     */
    public Bimestre getBimestre(int numeroBimestre) {
        if (numeroBimestre >= 1 && numeroBimestre <= 4) {
            return this.bimestres.get(numeroBimestre - 1);
        }
        return null;
    }

    public List<Bimestre> getBimestres() {
        return bimestres;
    }
}
