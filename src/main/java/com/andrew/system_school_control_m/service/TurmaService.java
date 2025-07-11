package com.andrew.system_school_control_m.service;

import com.andrew.system_school_control_m.model.Aluno;
import com.andrew.system_school_control_m.model.Turma;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
public class TurmaService {

    private Turma turma;

    @PostConstruct
    private void init(){
        this.turma = new Turma ("Turma Test");
        turma.addDisciplinaAoCurriculo("Matemática");
        turma.addDisciplinaAoCurriculo("Ingles");

        turma.addAluno(new Aluno("Aluno Test1"));
        turma.addAluno(new Aluno("Aluno Test2"));
        turma.addAluno(new Aluno("Aluno Test3"));
    }

    /**
     * Retorna a lista dos alunos
     * @return uma lista de objetos Aluno
     */
    public List<Aluno> listarTodosAlunos(){
        return turma.getAlunos();
    }

    /**
     * Cria um novo aluno e adiciona a turma ja existente
     * @return O Aluno que foi criado e adicionado
     */
    public Aluno adicionarAluno(String nome){
        if (nome == null || nome.trim().isEmpty()){
            return null;
        }
        Aluno novoAluno = new Aluno(nome);
        turma.addAluno(novoAluno);
        return novoAluno;
    }

    /**
     * Remove o aluno da turma buscando pelo nome
     * @return true se o aluno foi encontrado e removido, false caso contrário.
     */
    public boolean removerAluno(String nome){
        return turma.removerAluno(nome);
    }

    // Atualiza o nome de um aluno existente
    public Aluno atualizarNomeAluno(String nomeAtual, String novoNome){
        Aluno alunoParaAtualizar = turma.buscarAluno(nomeAtual);

        if (alunoParaAtualizar != null) {
            alunoParaAtualizar.setNome(novoNome);
            return alunoParaAtualizar;
        }
        return null;
    }
}
