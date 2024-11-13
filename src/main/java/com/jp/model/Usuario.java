package com.jp.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int idade;
    private String cpf;
    private String senha;
    private List<Conta> contasDoUsuario = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Conta> getContasDoUsuario() {
        return contasDoUsuario;
    }

    public void setContasDoUsuario(List<Conta> contasDoUsuario) {
        this.contasDoUsuario = contasDoUsuario;
    }
}
