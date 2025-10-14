package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.RepositoryPessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class controller {
    @Autowired
    private RepositoryPessoa acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @GetMapping("/")
    public String mensagem(){
        return "Olá, Mundo!";
    }
    
    @GetMapping("/boas")
    public String boasvindas() {
        return "Seja bem vindo(a)!";    
    }
    
    @GetMapping("/boas/{nome}")
    public String boasvindas(@PathVariable String nome) {
        return "Seja bem vindo(a) " + nome + "!";
    }
    
}
