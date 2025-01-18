package com.jp.model;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private List<Conta> contas;
    private int numeroAgencia;

    public Agencia() {
        this.contas = new ArrayList<>();
    }

    public Agencia(int numero) {
        this.contas = new ArrayList<>();
        this.numeroAgencia = numero;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
}
