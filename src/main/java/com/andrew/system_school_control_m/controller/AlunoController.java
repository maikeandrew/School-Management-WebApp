package com.andrew.system_school_control_m.controller;

import com.andrew.system_school_control_m.model.Aluno;
import com.andrew.system_school_control_m.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return turmaService.listarTodosAlunos();
    }

    /**
     * Ep para criar novo aluno
     * Respondo a requisicoes POST em "/api/alunos'
     */
    @PostMapping
    public ResponseEntity<Aluno> adicionarAluno(@RequestParam String nome){
        Aluno novoAluno = turmaService.adicionarAluno(nome);

        if (novoAluno != null){
            return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Ep para excluir um aluno pelo nome.
     * Responde a requisicao DELETE
     */
    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> removerAluno(@PathVariable String nome){
        boolean foiRemovido = turmaService.removerAluno(nome);

        if (foiRemovido) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // EP Update no nome do aluno
    @PutMapping("/{nomeAtual}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable String nomeAtual, @RequestParam String novoNome){
        Aluno alunoAtualizado = turmaService.atualizarNomeAluno(nomeAtual, novoNome);

        if (alunoAtualizado != null){
            return new ResponseEntity<>(alunoAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}