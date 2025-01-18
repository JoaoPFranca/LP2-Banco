package com.jp.model;

public class ContaPoupanca extends Conta {
    private double rendimentoMensal = 0.05;

    @Override
    public void setSaldo(double saldo) {
        double saldoComRendimento = saldo + (saldo * getRendimentoMensal());
        this.saldo = saldoComRendimento;
        System.out.println("Rendimento:" + getRendimentoMensal());
    }

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }
}
