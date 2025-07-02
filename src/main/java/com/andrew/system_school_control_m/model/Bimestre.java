package com.andrew.system_school_control_m.model;

import java.util.ArrayList;
import java.util.List;

public class Bimestre {

    private final List<Double> notasTrabalhos;
    private double notaProva;

    public Bimestre() {
        this.notasTrabalhos = new ArrayList<>();
        this.notaProva = 0.0;
    }

    /**
     * Adiciona uma nota de trabalho ao bimestre.
     *
     * @param nota A nota do trabalho.
     */
    public void adicionarNotaTrabalho(double nota) {
        this.notasTrabalhos.add(nota);
    }

    /**
     * Define a nota da prova do bimestre.
     *
     * @param nota A nota da prova.
     */
    public void setNotaProva(double nota) {
        this.notaProva = nota;
    }

    /**
     * Calcula a média aritmética de todas as notas de trabalho
     *
     * @return A média dos trabalhos
     */
    public double calcularMediaTrabalhos() {
        if (notasTrabalhos.isEmpty()) {
            return 0.0;
        }
        double somaTrabalhos = 0.0;
        for (double nota : this.notasTrabalhos) {
            somaTrabalhos += nota;
        }
        return somaTrabalhos / this.notasTrabalhos.size();
    }

    /**
     * Calcula a nota final do bimestre como a média aritmética de todas as
     * avaliações (trabalhos e prova)
     *
     * @return A média ponderada do bimestre
     */
    public double calcularNotaBimestre() {
        double somaTotal = 0.0;
        for (double notaTrabalho : this.notasTrabalhos) {
            somaTotal += notaTrabalho;
        }
        somaTotal += this.notaProva;

        int numeroDeAvaliacoes = this.notasTrabalhos.size() + 1;

        if (numeroDeAvaliacoes == 0) {
            return 0.0;
        }
        return somaTotal / numeroDeAvaliacoes;
    }

    /**
     * Verifica se a média do bimestre e necessária para aprovação
     *
     * @param mediaBimestreParaAprovar A nota mínima para ser aprovado no bimestre.
     * @return true se a nota for suficiente, false caso contrário.
     */
    public boolean verificarAprovacaoBimestre(double mediaBimestreParaAprovar) {
        return calcularNotaBimestre() >= mediaBimestreParaAprovar;
    }

    //Getters
    public List<Double> getNotasTrabalhos() {
        return notasTrabalhos;
    }

    public double getNotaProva() {
        return notaProva;
    }
}
