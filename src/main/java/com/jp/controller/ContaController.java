package com.jp.controller;


import com.jp.exception.BancoException;
import com.jp.model.*;

import java.util.Random;

public class ContaController {
    public ContaCorrente cadastroCorrente(Usuario usuario, Agencia agencia) {
        ContaCorrente novaConta = new ContaCorrente();
        Random random = new Random();
        int numeroConta = 1000 + random.nextInt(9000); //Garantindo que seja um número random de 4 dígitos
        novaConta.setNumeroDaConta(numeroConta);
        novaConta.setSaldo(0d);
        novaConta.setUsuario(usuario);
        usuario.getContasDoUsuario().add(novaConta);
        agencia.getContas().add(novaConta);
        return novaConta;
    }

    public ContaPoupanca cadastroPoupanca(Usuario usuario, Agencia agencia) {
        ContaPoupanca novaConta = new ContaPoupanca();
        Random random = new Random();
        int numeroConta = 1000 + random.nextInt(9000); //Garantindo que seja um número random de 4 dígitos
        novaConta.setNumeroDaConta(numeroConta);
        novaConta.setSaldo(0d);
        novaConta.setUsuario(usuario);
        usuario.getContasDoUsuario().add(novaConta);
        agencia.getContas().add(novaConta);
        return novaConta;
    }

    public ContaSalario cadastroSalario(Usuario usuario, Agencia agencia, Conta contaDoEmpregador) {
        ContaSalario novaConta = new ContaSalario();
        Random random = new Random();
        int numeroConta = 1000 + random.nextInt(9000); //Garantindo que seja um número random de 4 dígitos
        novaConta.setNumeroDaConta(numeroConta);
        novaConta.setSaldo(0d);
        novaConta.setUsuario(usuario);
        novaConta.setEmpregador(contaDoEmpregador);
        usuario.getContasDoUsuario().add(novaConta);
        agencia.getContas().add(novaConta);
        return novaConta;
    }

    public void sacar(Conta conta, Double valor, Usuario usuario) {
        if (conta.getUsuario() != usuario) {
            throw new BancoException("Você não tem permissão para fazer isso.");
        }
        if (conta.getSaldo() >= valor) {
            if(conta instanceof ContaSalario) {
                if(((ContaSalario) conta).getNumMaxSaques() >= ((ContaSalario) conta).getNumSaquesAtual()) {
                    throw new BancoException("Número máximo de saques excedido. Tente novamente mais tarde.");
                }
            }
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque feito! Saldo atual: " + conta.getSaldo());
        } else {
            throw new BancoException("Saldo Insuficiente.");
        }
    }


    public void depositar(Conta conta, Double valor, Usuario usuario) {
        if (conta.getUsuario() != usuario) {
            throw new BancoException("Você não tem permissão para fazer isso.");
        }
        if (conta instanceof ContaCorrente) {
            conta.setSaldo(conta.getSaldo() + (valor * ((ContaCorrente) conta).getTaxasManutencao()));
        } else if (conta instanceof ContaPoupanca) {
            conta.setSaldo(conta.getSaldo() + (valor * ((ContaPoupanca) conta).getRendimentoMensal()));
        } else {
                conta.setSaldo(conta.getSaldo() + valor);
        }
    }

    public boolean transferencia(Conta conta1, Conta conta2, double valor, Usuario usuario, Banco banco) {
        //O dinheiro sai da conta1 e vai para a conta2
        if(conta2 instanceof ContaSalario) {
            if(!(((ContaSalario) conta2).getEmpregador().equals(conta1))) {
                throw new BancoException("Sua conta ou a conta dele é restrita a depósitos de empregador.");
            }
        }

        if(conta1.getUsuario().equals(usuario)) {
            if(conta1.getSaldo() >= valor) {
                sacar(conta1, valor, usuario);
                conta2.setSaldo(conta2.getSaldo() + valor);
                Transacao transacao = new Transacao(valor, conta1, conta2);
                banco.getTransacoes().add(transacao);
                return true;
            } else {
                throw new BancoException("Saldo insuficiente.");
            }

        }
        throw new BancoException("Você não tem permissão para fazer isso.");
    }

    public Conta acharContaDoUsuarioPeloNumero(long numeroConta, Usuario usuario) {
       for(Conta conta : usuario.getContasDoUsuario()) {
           if(conta.getNumeroDaConta() == numeroConta) {
               return conta;
           }
       }
       return null;
    }

    public Conta acharContaPeloNumero(long numeroConta, Agencia agencia) {
        for(Conta conta : agencia.getContas()) {
            if(conta.getNumeroDaConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
