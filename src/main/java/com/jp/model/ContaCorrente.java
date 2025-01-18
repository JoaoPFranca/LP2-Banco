package com.jp.model;

public class ContaCorrente extends Conta {
    private double taxasManutencao = 0.95; //5%

    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo * getTaxasManutencao();
    }

    public double getTaxasManutencao() {
        return taxasManutencao;
    }

    public void setTaxasManutencao(double taxasManutencao) {
        this.taxasManutencao = taxasManutencao;
    }
}
