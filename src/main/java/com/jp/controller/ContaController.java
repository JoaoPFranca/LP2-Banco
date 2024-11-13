package com.jp.controller;


import com.jp.model.Banco;
import com.jp.model.Conta;
import com.jp.model.Tipo;
import com.jp.model.Usuario;

import java.util.Random;

public class ContaController {
    public Conta cadastro(Usuario usuario, Tipo tipoConta, Banco banco) {
        Conta novaConta = new Conta();
        Random random = new Random();
        int numeroConta = 1000 + random.nextInt(9000); //Garantindo que seja um número random de 4 dígitos
        novaConta.setNumeroDaConta(numeroConta);
        novaConta.setTipo(tipoConta);
        novaConta.setSaldo(0d);
        novaConta.setUsuario(usuario);
        usuario.getContasDoUsuario().add(novaConta);
        banco.getContas().add(novaConta);
        return novaConta;
    }

    public void sacar(Conta conta, Double valor, Usuario usuario) {
        if (conta.getUsuario() != usuario) {
            System.out.println("Você não tem permissão para fazer isso.");
        }
        if (conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque feito! Saldo atual: " + conta.getSaldo());
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void depositar(Conta conta, Double valor, Usuario usuario) {
        if(conta.getUsuario() != usuario) {
            System.out.println("Você não tem permissão para fazer isso.");
            return;
        }
        conta.setSaldo(conta.getSaldo() + valor);
    }

    public boolean transferencia(Conta conta1, Conta conta2, double valor, Usuario usuario) {
        //O dinheiro sai da conta1 e vai para a conta2
        if(conta1.getUsuario().equals(usuario)) {
            if(conta1.getSaldo() >= valor) {
                sacar(conta1, valor, usuario);
                conta2.setSaldo(conta2.getSaldo() + valor);
                return true;
            } else {
                System.out.println("Saldo insuficiente!");
                return false;
            }

        }
        System.out.println("Você não tem permissão para fazer isso.");
        return false;
    }

    public Conta acharContaDoUsuarioPeloNumero(long numeroConta, Usuario usuario) {
       for(Conta conta : usuario.getContasDoUsuario()) {
           if(conta.getNumeroDaConta() == numeroConta) {
               return conta;
           }
       }
       return null;
    }

    public Conta acharContaPeloNumero(long numeroConta, Banco banco) {
        for(Conta conta : banco.getContas()) {
            if(conta.getNumeroDaConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
