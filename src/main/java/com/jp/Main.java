package com.jp;

import com.jp.controller.ContaController;
import com.jp.controller.UsuarioController;
import com.jp.model.Banco;
import com.jp.model.Conta;
import com.jp.model.Tipo;
import com.jp.model.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuarioLogado = null;
        final UsuarioController usuarioController = new UsuarioController();
        final ContaController contaController = new ContaController();
        Banco bancoAtual = new Banco();
        Tipo corrente = new Tipo("Conta Corrente");
        Tipo poupanca = new Tipo("Conta Poupança");
        int entrada1, entrada2;

        while (true) {
            if (usuarioLogado == null) {
                System.out.println("--------Banco João Pedro de França Barboza----------");
                System.out.println("|                                                  |");
                System.out.println("|          Usuário - Selecione uma opção:          |");
                System.out.println("|                 1- Cadastro                      |");
                System.out.println("|                 2- Login                         |");
                System.out.println("|                 3- Sair                          |");
                System.out.println("|                                                  |");
                System.out.println("----------------------------------------------------");
                entrada1 = sc.nextInt();
                sc.nextLine();
                if (entrada1 == 1) {
                    System.out.println("--------Banco João Pedro de França Barboza----------");
                    System.out.println("|                   Cadastro                       |");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Qual o seu nome?");
                    String entradaNome = sc.nextLine();
                    System.out.println("Quantos anos você tem?");
                    int entradaIdade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Qual o seu CPF (será usado para login)?");
                    String entradaCPF = sc.nextLine();
                    System.out.println("Diga uma senha a ser usada para login:");
                    String entradaSenha = sc.nextLine();
                    usuarioController.cadastro(bancoAtual, entradaNome, entradaIdade, entradaCPF, entradaSenha);
                } else if(entrada1 == 2) {
                    System.out.println("--------Banco João Pedro de França Barboza----------");
                    System.out.println("|                    Login                         |");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Digite seu CPF");
                    String entradaCPF = sc.nextLine();
                    System.out.println("Digite sua senha");
                    String entradaSenha = sc.nextLine();
                    Usuario usuario = usuarioController.login(bancoAtual, entradaCPF, entradaSenha);
                    if (usuario != null) {
                        usuarioLogado = usuario;
                    } else {
                        System.out.println("O login falhou. Tente novamente.");
                    }
                } else {
                    break;
                }
            } else {
                System.out.println("--------Banco João Pedro de França Barboza----------");
                System.out.println("|       Bem vindo " + usuarioLogado.getNome() + "   |");
                System.out.println("|             O que deseja fazer hoje?             |");
                System.out.println("|                 1- Abrir conta                   |");
                System.out.println("|                 2- Consultar saldo               |");
                System.out.println("|                 3- Depositar                     |");
                System.out.println("|                 4- Sacar                         |");
                System.out.println("|                 5- Transferir                    |");
                System.out.println("|                 6- Sair da conta                 |");
                System.out.println("|                 7- Sair da aplicação             |");
                System.out.println("|                                                  |");
                System.out.println("----------------------------------------------------");
                entrada2 = sc.nextInt();
                sc.nextLine();
                if (entrada2 == 1) {
                    System.out.println("--------Banco João Pedro de França Barboza----------");
                    System.out.println("|                  Abrir conta                      |");
                    System.out.println("|              Qual o tipo da conta?                |");
                    System.out.println("|                 1 - Corrente                      |");
                    System.out.println("|                 2 - Poupanca                      |");
                    System.out.println("----------------------------------------------------");
                    int entradaConta = sc.nextInt();
                    sc.nextLine();
                    Tipo tipoConta;
                    if (entradaConta == 1) {
                        tipoConta = corrente;
                    } else {
                        tipoConta = poupanca;
                    }
                    Conta contaNova = contaController.cadastro(usuarioLogado, tipoConta, bancoAtual);
                    if (contaNova != null) {
                        System.out.println("Conta cadastrada. Número da conta: " + contaNova.getNumeroDaConta());
                    } else {
                        System.out.println("Não foi possível criar sua conta.");
                    }
                } else if (entrada2 == 2) {
                    System.out.println("--------Banco João Pedro de França Barboza----------");
                    System.out.println("|                Consultar saldo                    |");
                    System.out.println("----------------------------------------------------");
                    System.out.println("De qual conta? Informe o número");
                    int contaEscolhidaSaldo = sc.nextInt();
                    sc.nextLine();
                    Conta conta = contaController.acharContaDoUsuarioPeloNumero(contaEscolhidaSaldo, usuarioLogado);
                    if (conta == null) {
                        System.out.println("Você não tem nenhuma conta com esse número.");
                    } else {
                        System.out.println("Saldo: " + conta.getSaldo());
                    }
                } else if (entrada2 == 3) {
                    System.out.println("--------Banco João Pedro de França Barboza----------");
                    System.out.println("|                   Depositar                      |");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Em qual conta? Informe o número");
                    int contaEscolhidaDeposito = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Qual valor?");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    Conta conta = contaController.acharContaDoUsuarioPeloNumero(contaEscolhidaDeposito, usuarioLogado);
                    if (conta == null) {
                        System.out.println("Não há nenhuma conta com esse número.");
                    } else {
                        contaController.depositar(conta, valor, usuarioLogado);
                        System.out.println("Depósito feito! Saldo atual: " + conta.getSaldo());
                    }
                } else if (entrada2 == 4) {
                    System.out.println("--------Banco João Pedro de França Barboza----------");
                    System.out.println("|                     Sacar                        |");
                    System.out.println("----------------------------------------------------");
                    System.out.println("De qual conta? Informe o número");
                    int contaEscolhidaSaque = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Qual valor?");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    Conta conta = contaController.acharContaDoUsuarioPeloNumero(contaEscolhidaSaque, usuarioLogado);
                    if (conta == null) {
                        System.out.println("Não há nenhuma conta com esse número.");
                    } else {
                        contaController.sacar(conta, valor, usuarioLogado);
                    }
                } else if (entrada2 == 5) {
                    System.out.println("--------Banco João Pedro de França Barboza----------");
                    System.out.println("|                   Transferir                      |");
                    System.out.println("----------------------------------------------------");
                    System.out.println("De qual conta? Informe o número");
                    int contaEscolhidaTransferencia = sc.nextInt();
                    sc.nextLine();
                    Conta contaQueVaiPagar = contaController.acharContaDoUsuarioPeloNumero(contaEscolhidaTransferencia, usuarioLogado);
                    System.out.println("Para qual conta? Informe o número");
                    int contaAReceberTransferencia = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Qual o valor?");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    Conta contaAReceber = contaController.acharContaPeloNumero(contaAReceberTransferencia, bancoAtual);
                    if (contaQueVaiPagar != null && contaAReceber != null) {
                        contaController.transferencia(contaQueVaiPagar, contaAReceber, valor, usuarioLogado);
                    } else {
                        System.out.println("Alguma das contas informadas não existe. Tente novamente.");
                    }

                } else if (entrada2 == 6) {
                    usuarioLogado = null;
                } else {
                   return;
                }
            }
        }
    }
}