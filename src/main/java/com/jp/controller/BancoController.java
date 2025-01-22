package com.jp.controller;

import com.jp.model.Agencia;
import com.jp.model.Banco;
import com.jp.model.Conta;
import com.jp.model.Transacao;

import java.io.*;

public class BancoController {
    public boolean criarArquivo(Banco banco) throws IOException {
        FileWriter arquivo = new FileWriter("D:\\Projetos\\Banco\\banco.csv");
        PrintWriter gravarArquivo = new PrintWriter(arquivo);

        gravarArquivo.println("----- Banco João Pedro de França Barboza -----");
        gravarArquivo.println("----- Contas Registradas no banco: -----");
        for(Agencia agencia : banco.getAgencias()) {
            gravarArquivo.println("----- Agência: " + agencia.getNumeroAgencia() + " ---------");
            gravarArquivo.println("CPF do dono - Número da conta - Saldo da conta");
            for(Conta conta : agencia.getContas()) {
                gravarArquivo.println(conta.getUsuario().getCpf() + "," + conta.getNumeroDaConta() + "," + conta.getSaldo());
            }
        }
        gravarArquivo.println();
        gravarArquivo.println("----- Transações Registradas no banco: -----");
        for(Transacao transacao : banco.getTransacoes()) {
            gravarArquivo.println("Valor - Quem mandou - Quem Recebeu");
            gravarArquivo.println(transacao.getValor() + " - " + transacao.getPagante().getUsuario().getNome() + " - " + transacao.getRecebedor().getUsuario().getNome());
        }

        arquivo.close();
        System.out.println("O banco foi totalmente exportado para o arquivo banco.csv!");
        return true;
    }
}
