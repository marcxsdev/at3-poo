package ex3;

public class QuartoDuplo implements Acomodacao, ServicoAdicional {
    private static final double DIARIA = 180.0;

    @Override
    public double calcularDiaria() {
        return DIARIA;
    }

    @Override
    public double calcularServico(int numPessoas, int dias) {
        double cafeDaManha = 20.0 * numPessoas * dias;
        double limpezaExtra = 30.0 * dias;
        return cafeDaManha + limpezaExtra;
    }

    @Override
    public void exibirDetalhes(int dias) {
        double custoDiaria = calcularDiaria() * dias;
        double custoServicos = calcularServico(2, dias);
        double custoTotal = custoDiaria + custoServicos;
        System.out.println("Quarto Duplo - Diárias: R$" + custoDiaria);
        System.out.println("Serviços adicionais: R$" + custoServicos);
        System.out.println("Custo Total: R$" + custoTotal);
    }
}

