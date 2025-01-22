package com.jp.model;

public class ContaPoupanca extends Conta {
    private double rendimentoMensal = 1.05;

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }
}
