package ex1;

public class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial(String cliente, String numeroConta, double saldoInicial, double limite) {
        super(cliente, numeroConta, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo + limite >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Limite: R$ " + limite);
    }
}

