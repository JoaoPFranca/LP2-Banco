package com.jp.model;

public class ContaSalario extends Conta {
    private int numSaquesAtual;
    private int numMaxSaques;
    private Conta empregador;

    public int getNumSaquesAtual() {
        return numSaquesAtual;
    }

    public void setNumSaquesAtual(int numSaquesAtual) {
        this.numSaquesAtual = numSaquesAtual;
    }

    public int getNumMaxSaques() {
        return numMaxSaques;
    }

    public void setNumMaxSaques(int numMaxSaques) {
        this.numMaxSaques = numMaxSaques;
    }

    public Conta getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Conta empregador) {
        this.empregador = empregador;
    }
}
