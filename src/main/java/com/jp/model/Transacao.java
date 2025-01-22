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

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Conta getPagante() {
        return pagante;
    }

    public void setPagante(Conta pagante) {
        this.pagante = pagante;
    }

    public Conta getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Conta recebedor) {
        this.recebedor = recebedor;
    }
}
