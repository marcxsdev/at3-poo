package ex3;

import java.util.Scanner;

public class HotelApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tipo de acomodação:");
        System.out.println("1 - Quarto Simples");
        System.out.println("2 - Quarto Duplo");
        System.out.println("3 - Suíte");
        int escolha = scanner.nextInt();

        System.out.println("Quantos dias será a estadia?");
        int dias = scanner.nextInt();

        Acomodacao acomodacao = null;

        switch (escolha) {
            case 1:
                acomodacao = new QuartoSimples();
                break;
            case 2:
                acomodacao = new QuartoDuplo();
                break;
            case 3:
                acomodacao = new Suite();
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        acomodacao.exibirDetalhes(dias);
        scanner.close();
    }
}

