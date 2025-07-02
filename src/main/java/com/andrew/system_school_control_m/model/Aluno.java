package com.andrew.system_school_control_m.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {
    // Encapsulamento
    private String nome;
    private List<Disciplina> disciplinas;

    public Aluno(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    // Adicionar diciplina para o aluno
    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    //Buscar a disciplina pelo nome
    public Disciplina buscarDisciplina(String nome) {
        for (Disciplina disciplina : this.disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                return disciplina;
            }
        }
        return null;
    }


    //getters e Setters
    public String getNome() {
        return this.nome;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(nome.toLowerCase(), aluno.nome.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }

}