package com.jp.controller;

import com.jp.model.Banco;
import com.jp.model.Usuario;

import java.util.List;

public class UsuarioController {
    public void cadastro(Banco banco, String nome, int idade, String cpf, String senha) {
        Usuario novoUsuario = new Usuario();
        List<Usuario> usuariosNoBanco = banco.getUsuarios();
        if(acharUsuarioNoBancoPorCPF(usuariosNoBanco, cpf) != null || acharUsuarioNoBancoPorNome(usuariosNoBanco, nome) != null) {
            System.out.println("Já tem um usuário com esse CPF/NOME no banco. Tente novamente.");
            return;
        }
        novoUsuario.setNome(nome);
        novoUsuario.setIdade(idade);
        novoUsuario.setCpf(cpf);
        novoUsuario.setSenha(senha);
        banco.getUsuarios().add(novoUsuario);
    }

    public Usuario login(Banco banco, String cpf, String senha) {
        List<Usuario> usuariosNoBanco = banco.getUsuarios();
        Usuario usuario = acharUsuarioNoBancoPorCPF(usuariosNoBanco, cpf);
        if(usuario != null) {
            if(usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario acharUsuarioNoBancoPorNome(List<Usuario> usuarios, String nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().equals(nome)) {
                return u;
            }
        }
        return null;
    }

    public Usuario acharUsuarioNoBancoPorCPF(List<Usuario> usuarios, String cpf) {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                return u;
            }
        }
        return null;
    }


}
