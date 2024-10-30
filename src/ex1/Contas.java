package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contas {
    private static List<ContaBancaria> contas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1. Adicionar Conta");
            System.out.println("2. Sacar");
            System.out.println("3. Depositar");
            System.out.println("4. Calcular Novo Saldo (Conta Poupança)");
            System.out.println("5. Mostrar Dados das Contas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarConta(scanner);
                    break;
                case 2:
                    realizarSaque(scanner);
                    break;
                case 3:
                    realizarDeposito(scanner);
                    break;
                case 4:
                    calcularNovoSaldo(scanner);
                    break;
                case 5:
                    mostrarDados();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarConta(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String cliente = scanner.next();
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.next();
        System.out.print("Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Escolha o tipo de conta (1- Poupança, 2- Especial): ");
        int tipoConta = scanner.nextInt();

        if (tipoConta == 1) {
            System.out.print("Digite o dia de rendimento: ");
            int diaRendimento = scanner.nextInt();
            contas.add(new ContaPoupanca(cliente, numeroConta, saldo, diaRendimento));
        } else if (tipoConta == 2) {
            System.out.print("Digite o limite: ");
            double limite = scanner.nextDouble();
            contas.add(new ContaEspecial(cliente, numeroConta, saldo, limite));
        } else {
            System.out.println("Tipo de conta inválido.");
        }
    }

    private static void realizarSaque(Scanner scanner) {
        ContaBancaria conta = buscarConta(scanner);
        if (conta != null) {
            System.out.print("Digite o valor para saque: ");
            double valor = scanner.nextDouble();
            if (conta.sacar(valor)) {
                System.out.println("Saque realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void realizarDeposito(Scanner scanner) {
        ContaBancaria conta = buscarConta(scanner);
        if (conta != null) {
            System.out.print("Digite o valor para depósito: ");
            double valor = scanner.nextDouble();
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void calcularNovoSaldo(Scanner scanner) {
        ContaBancaria conta = buscarConta(scanner);
        if (conta instanceof ContaPoupanca) {
            System.out.print("Digite a taxa de rendimento: ");
            double taxaRendimento = scanner.nextDouble();
            ((ContaPoupanca) conta).calcularNovoSaldo(taxaRendimento);
            System.out.println("Novo saldo calculado.");
        } else {
            System.out.println("A conta selecionada não é do tipo poupança.");
        }
    }

    private static void mostrarDados() {
        for (ContaBancaria conta : contas) {
            conta.mostrarDados();
            System.out.println("----------");
        }
    }

    private static ContaBancaria buscarConta(Scanner scanner) {
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.next();
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }
}
