package com.jp.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Usuario> usuarios;
    private List<Agencia> agencias;
    private List<Transacao> transacoes;

    public Banco() {
        this.agencias = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
