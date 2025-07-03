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
}