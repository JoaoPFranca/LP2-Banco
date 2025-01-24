package com.jp.controller;

import com.jp.exception.BancoException;
import com.jp.model.*;

import java.io.*;

public class BancoController {
    final ContaController contaController = new ContaController();
    final UsuarioController usuarioController = new UsuarioController();

    public boolean exportar(Banco banco) throws IOException {
        FileWriter arquivo = new FileWriter("D:\\Projetos\\Banco\\banco.csv");
        PrintWriter gravarArquivo = new PrintWriter(arquivo);

        gravarArquivo.println("----- Banco João Pedro de França Barboza -----");
        gravarArquivo.println("----- Contas Registradas no banco: -----");
        for(Agencia agencia : banco.getAgencias()) {
            gravarArquivo.println("----- Agência: " + agencia.getNumeroAgencia() + " ---------");
            gravarArquivo.println("CPF do dono - Nome do dono - Idade do dono - Senha do dono - Número da conta - Saldo da conta");
            for(Conta conta : agencia.getContas()) {
                gravarArquivo.println(conta.getUsuario().getCpf() + "," + conta.getUsuario().getNome() + "," + conta.getUsuario().getIdade() + "," + conta.getUsuario().getSenha() + "," + conta.getNumeroDaConta() + "," + conta.getSaldo());
            }
        }
        gravarArquivo.println();
        gravarArquivo.println("----- Transações Registradas no banco: -----");
        for(Transacao transacao : banco.getTransacoes()) {
            gravarArquivo.println("Valor - Quem mandou - Quem Recebeu");
            gravarArquivo.println(transacao.getValor() + " - " + transacao.getPagante().getNumeroDaConta() + " - " + transacao.getRecebedor().getNumeroDaConta());
        }

        arquivo.close();
        System.out.println("O banco foi totalmente exportado para o arquivo banco.csv!");
        return true;
    }

    public boolean importar(Banco banco) throws IOException {
        File arquivo = new File("D:\\Projetos\\Banco\\banco.csv");
        if (!arquivo.exists()) {
            throw new BancoException("Ainda não há nenhum arquivo de exportação do banco.");
        }
        FileReader leitor = new FileReader(arquivo);
        BufferedReader lerArquivo = new BufferedReader(leitor);
        String linha;

        Agencia agenciaAtual = null;
        while((linha = lerArquivo.readLine()) != null) {
            linha = linha.trim();
            if(linha.startsWith("----- Agência: ")) {
                String[] partes = linha.split(":");
                int numeroAgencia = Integer.parseInt(partes[1].trim().split(" ")[0]);
                agenciaAtual = new Agencia(numeroAgencia);
                banco.getAgencias().add(agenciaAtual);
            } else if(linha.startsWith("CPF do dono")) {
                continue;
            } else if (linha.contains(",") && agenciaAtual != null) {
                String[] dadosConta = linha.split(",");
                String cpf = dadosConta[0].trim();
                String nome = dadosConta[1].trim();
                int idade = Integer.parseInt(dadosConta[2].trim());
                String senha = dadosConta[3].trim();
                int numeroConta = Integer.parseInt(dadosConta[4].trim());
                double saldo = Double.parseDouble(dadosConta[5].trim());


                Usuario usuario = usuarioController.cadastro(banco, nome, idade, cpf, senha);

                Conta conta = contaController.cadastroCorrente(usuario, agenciaAtual);
                conta.setSaldo(saldo);
                conta.setNumeroDaConta(numeroConta);
                agenciaAtual.getContas().add(conta);
            } else if (linha.startsWith("Valor - Quem mandou - Quem Recebeu")) {
                continue;
            } else if (linha.contains(" - ")) {
                String[] dadosTransacao = linha.split(" - ");
                double valor = Double.parseDouble(dadosTransacao[0].trim());
                long numeroContaPagante = Long.parseLong(dadosTransacao[1].trim());
                long numeroContaRecebedor = Long.parseLong(dadosTransacao[2].trim());

                Conta pagante = contaController.acharContaPeloNumero(numeroContaPagante, agenciaAtual);
                Conta recebedor = contaController.acharContaPeloNumero(numeroContaRecebedor, agenciaAtual);

                if (pagante != null && recebedor != null) {
                    Transacao transacao = new Transacao(valor, pagante, recebedor);
                    banco.getTransacoes().add(transacao);
                }
            }
        }
        leitor.close();
        System.out.println("O banco foi totalmente importado para a aplicação!");
        return true;
    }
}
