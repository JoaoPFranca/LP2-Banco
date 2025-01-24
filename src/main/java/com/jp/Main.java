package com.jp;

import com.jp.controller.BancoController;
import com.jp.controller.ContaController;
import com.jp.controller.UsuarioController;
import com.jp.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Usuario usuarioLogado = null;
        final UsuarioController usuarioController = new UsuarioController();
        final ContaController contaController = new ContaController();
        final BancoController bancoController = new BancoController();
        Banco bancoAtual = new Banco();
        Agencia agencia1 = new Agencia(1);
        Agencia agencia2 = new Agencia(2);
        bancoAtual.getAgencias().add(agencia1);
        bancoAtual.getAgencias().add(agencia2);
        int entrada1, entrada2;

        while (true) {
            if (usuarioLogado == null) {
                System.out.println("--------Banco João Pedro de França Barboza----------");
                System.out.println("|                                                  |");
                System.out.println("|          Usuário - Selecione uma opção:          |");
                System.out.println("|                 1- Cadastro                      |");
                System.out.println("|                 2- Login                         |");
                System.out.println("|                 3- Sair                          |");
                System.out.println("|                 4- Exportar dados do banco       |");
                System.out.println("|                 5- Importar dados do banco       |");
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
                }
                else if(entrada1 == 2) {
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
                }
                else if(entrada1 == 3) {
                    break;
                }
                else if(entrada1 == 4) {
                    bancoController.exportar(bancoAtual);
                } else {
                    bancoController.importar(bancoAtual);
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
                    System.out.println("|                Em qual agência?                   |");
                    System.out.println("|                 1 - Agência 1                     |");
                    System.out.println("|                 2 - Agência 2                     |");
                    System.out.println("----------------------------------------------------");
                    int entradaAgencia = sc.nextInt();
                    Agencia agenciaAtual = null;
                    if(entradaAgencia == 1) {
                        agenciaAtual = agencia1;
                    } else if (entradaAgencia == 2) {
                        agenciaAtual = agencia2;
                    } else {
                        System.out.println("Agência não existente.");
                        break;
                    }
                    System.out.println("--------Banco João Pedro de França Barboza----------");
                    System.out.println("|                  Abrir conta                      |");
                    System.out.println("|              Qual o tipo da conta?                |");
                    System.out.println("|                 1 - Corrente                      |");
                    System.out.println("|                 2 - Poupanca                      |");
                    System.out.println("|                 3 - Salário                       |");
                    System.out.println("----------------------------------------------------");
                    int entradaConta = sc.nextInt();
                    sc.nextLine();
                    Conta contaNova = null;
                    if (entradaConta == 1) {
                        contaNova = contaController.cadastroCorrente(usuarioLogado, agenciaAtual);
                    } else if(entradaConta == 2) {
                        contaNova = contaController.cadastroPoupanca(usuarioLogado, agenciaAtual);
                    } else {
                        System.out.println("--------Banco João Pedro de França Barboza----------");
                        System.out.println("|               Conta do Empregador                 |");
                        System.out.println("|    Digite o número da conta do seu empregador     |");
                        System.out.println("----------------------------------------------------");
                        int entradaContaEmp = sc.nextInt();
                        sc.nextLine();
                        System.out.println("--------Banco João Pedro de França Barboza----------");
                        System.out.println("|             Agência do Empregador                 |");
                        System.out.println("|    Digite o número da agência do seu empregador   |");
                        System.out.println("----------------------------------------------------");
                        int entradaAgenciaEmp = sc.nextInt();
                        sc.nextLine();
                        Agencia agenciaEmp = null;
                        if(entradaAgenciaEmp == 1) {
                            agenciaEmp = agencia1;
                        } else if (entradaAgenciaEmp == 2) {
                            agenciaEmp = agencia2;
                        } else {
                            System.out.println("Agência não existente.");
                        }
                        if(agenciaEmp != null) {
                            Conta contaEmp = contaController.acharContaPeloNumero(entradaContaEmp, agenciaEmp);
                            contaNova = contaController.cadastroSalario(usuarioLogado, agenciaAtual, contaEmp);
                        }
                    }
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
                    System.out.println("Qual a Agência?");
                    int numAgencia = sc.nextInt();
                    Agencia agenciaAtual = null;
                    if(numAgencia == 1) {
                        agenciaAtual = agencia1;
                    } else if (numAgencia == 2) {
                        agenciaAtual = agencia2;
                    } else {
                        System.out.println("Agência não existente.");
                    }
                    Conta contaAReceber = contaController.acharContaPeloNumero(contaAReceberTransferencia, agenciaAtual);
                    if (contaQueVaiPagar != null && contaAReceber != null) {
                        contaController.transferencia(contaQueVaiPagar, contaAReceber, valor, usuarioLogado, bancoAtual);
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