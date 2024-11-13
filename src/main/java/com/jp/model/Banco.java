package com.jp.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Usuario> usuarios;
    private List<Conta> contas;

    public Banco() {
        this.usuarios = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
