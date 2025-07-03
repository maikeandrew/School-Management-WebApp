package com.andrew.system_school_control_m.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para a Classe Turma")
class TurmaTest {

    private Turma turma;

    @BeforeEach
    void setUp() {
        turma = new Turma("5º Ano B");
    }

    @Test
    @DisplayName("Deve adicionar um aluno à lista da turma")
    void deveAdicionarUmAlunoCorretamente() {

        Aluno novoAluno = new Aluno("João Silva");

        turma.addAluno(novoAluno);

        assertEquals(1, turma.getAlunos().size(), "A lista de alunos deveria ter 1 aluno.");
        assertEquals("João Silva", turma.buscarAluno("João Silva").getNome(), "O nome do aluno buscado deveria ser 'João Silva'.");
    }

    @Test
    @DisplayName("Deve matricular um novo aluno em disciplinas já existentes")
    void deveMatricularNovoAlunoEmDisciplinasJaExistentes() {

        turma.addDisciplinaAoCurriculo("Matemática");
        turma.addDisciplinaAoCurriculo("Ciências");
        Aluno maria = new Aluno("Maria Souza");

        turma.addAluno(maria);

        Aluno alunaAdicionada = turma.buscarAluno("Maria Souza");
        assertNotNull(alunaAdicionada, "A aluna Maria deveria ter sido encontrada.");
        assertEquals(2, alunaAdicionada.getDisciplinas().size(), "Maria deveria estar matriculada em 2 disciplinas.");
        assertEquals("Matemática", alunaAdicionada.getDisciplinas().get(0).getNome());
    }

    @Test
    @DisplayName("Deve adicionar uma nova disciplina a todos os alunos existentes")
    void deveAdicionarNovaDisciplinaAlunosExistentes() {

        turma.addAluno(new Aluno("Carlos Pereira"));
        turma.addAluno(new Aluno("Ana Costa"));

        turma.addDisciplinaAoCurriculo("História");

        Aluno carlos = turma.buscarAluno("Carlos Pereira");
        Aluno ana = turma.buscarAluno("Ana Costa");
        assertEquals(1, carlos.getDisciplinas().size(), "Carlos deveria ter 1 disciplina.");
        assertEquals(1, ana.getDisciplinas().size(), "Ana deveria ter 1 disciplina.");
        assertEquals("História", carlos.getDisciplinas().get(0).getNome(), "A disciplina de Carlos deveria ser História.");
    }

    @Test
    @DisplayName("Deve remover um aluno corretamente da turma")
    void deveRemoverAlunoCorretamente() {
        turma.addAluno(new Aluno("Carlos Pereira"));
        assertEquals(1, turma.getAlunos().size(), "A turma deveria ter 1 aluno antes da remoção.");

        boolean foiRemovido = turma.removerAluno("Carlos Pereira");

        assertTrue(foiRemovido, "O método deveria retornar true, indicando sucesso na remoção.");
        assertEquals(0, turma.getAlunos().size(), "A lista de alunos deveria estar vazia após a remoção.");
        assertNull(turma.buscarAluno("Carlos Pereira"), "Buscar pelo aluno removido deveria retornar null.");
    }

    @Test
    @DisplayName("Não deve falhar ao tentar remover um aluno que não existe")
    void deveLidarComRemocaoDeAlunoInexistente() {
        // Arrange
        turma.addAluno(new Aluno("Aluno Existente"));

        // Act
        boolean foiRemovido = turma.removerAluno("Aluno Inexistente");

        // Assert
        assertFalse(foiRemovido, "O método deveria retornar false para um aluno inexistente.");
        assertEquals(1, turma.getAlunos().size(), "A lista de alunos não deveria ser modificada.");
    }
}
