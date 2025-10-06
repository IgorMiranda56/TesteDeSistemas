package br.com.example.projeto;

public class Usuario {
    private String nome;

    public Usuario(String nome) {
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}
