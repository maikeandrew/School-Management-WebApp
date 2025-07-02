package com.andrew.system_school_control_m.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nomeDaTurma;
    private List<Aluno> alunos;
    private List<String> nomesDisciplinas;
    private static final double MEDIA_PARA_APROVACAO = 6.0;
    private static final double MEDIA_BIMESTRE_PARA_APROVACAO = 6.0;

    public Turma(String nomeDaTurma) {
        this.nomeDaTurma = nomeDaTurma;
        this.alunos = new ArrayList<>();
        this.nomesDisciplinas = new ArrayList<>();
    }

    // Adiciona o aluno a materia
    public void addAluno(Aluno aluno) {
        for (String nomeDisciplina : this.nomesDisciplinas) {
            aluno.addDisciplina(new Disciplina(nomeDisciplina));
        }
        this.alunos.add(aluno);
    }

    //Excluir Aluno
    public boolean removerAluno(String nome) {
        Aluno alunoParaRemover = this.buscarAluno(nome);

        if (alunoParaRemover != null) {
            return this.alunos.remove(alunoParaRemover);
        }
        return false;
    }

    // Processo de busca dos alunos cadastrados
    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null; //Caso nao encontre
    }

    // Adiciona disciplina
    // (atualiza a lista e alunos registrado para cada nova disciplina)
    public void addDisciplinaAoCurriculo(String nomeDisciplina) {
        if (!this.nomesDisciplinas.contains(nomeDisciplina)) {
            this.nomesDisciplinas.add(nomeDisciplina);

            for (Aluno aluno : this.alunos) {
                aluno.addDisciplina(new Disciplina(nomeDisciplina));
            }
        }
    }

    //Adicionar alunos que nao estao em disciplinas
    public void addAlunoJaExistente(Aluno aluno) {
        if (!this.alunos.contains(aluno)) {
            this.alunos.add(aluno);
        }
    }

    // getters
    public double getMediaBimestreParaAprovacao(){
        return MEDIA_BIMESTRE_PARA_APROVACAO;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String getNomeDaTurma() {
        return this.nomeDaTurma;
    }

    public List<String> getNomesDisciplinas() {
        return this.nomesDisciplinas;
    }

    public double getMediaParaAprovacao() {
        return MEDIA_PARA_APROVACAO;
    }
}
