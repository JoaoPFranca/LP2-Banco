package com.jp.model;

public class Transacao {
    double valor;
    Conta pagante;
    Conta recebedor;

    public Transacao(double valor, Conta pagante, Conta recebedor) {
        this.valor = valor;
        this.pagante = pagante;
        this.recebedor = recebedor;
    }

    public double getValor() {
        return valor;
    }

    public Conta getConta1() {
        return pagante;
    }

    public Conta getConta2() {
        return recebedor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setConta1(Conta pagante) {
        this.pagante = pagante;
    }

    public void setConta2(Conta recebedor) {
        this.recebedor = recebedor;
    }
}
