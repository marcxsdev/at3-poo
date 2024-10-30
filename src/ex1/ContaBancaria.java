package ex1;

public class ContaBancaria {
    private String cliente;
    private String numeroConta;
    protected double saldo;

    public ContaBancaria(String cliente, String numeroConta, double saldoInicial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public String getCliente() {
        return cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void mostrarDados() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Saldo: R$ " + saldo);
    }
}