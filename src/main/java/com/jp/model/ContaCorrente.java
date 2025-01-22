package com.jp.model;

public class ContaCorrente extends Conta {
    private double taxasManutencao = 0.95; //5%

    public double getTaxasManutencao() {
        return taxasManutencao;
    }

    public void setTaxasManutencao(double taxasManutencao) {
        this.taxasManutencao = taxasManutencao;
    }
}
