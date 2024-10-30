package ex1;

public class ContaPoupanca extends ContaBancaria {
    private int diaDeRendimento;

    public ContaPoupanca(String cliente, String numeroConta, double saldoInicial, int diaDeRendimento) {
        super(cliente, numeroConta, saldoInicial);
        this.diaDeRendimento = diaDeRendimento;
    }

    public void calcularNovoSaldo(double taxaRendimento) {
        saldo += saldo * taxaRendimento;
    }

    public int getDiaDeRendimento() {
        return diaDeRendimento;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Dia de Rendimento: " + diaDeRendimento);
    }
}

