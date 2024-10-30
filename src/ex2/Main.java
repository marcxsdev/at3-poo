package ex2;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("ABC-1234", "Fiat", "Uno", 2015);
        Caminhao caminhao = new Caminhao("DEF-5678", "Volvo", "FH", 2012);
        Onibus onibus = new Onibus("GHI-9012", "Mercedes", "Tourismo", 2018);

        carro.exibirDetalhes();
        caminhao.exibirDetalhes();
        onibus.exibirDetalhes();
    }
}

