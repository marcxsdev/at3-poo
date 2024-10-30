package ex2;

abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    public abstract double calcularIPVA();
    public abstract void exibirDetalhes();

    // Getters e Setters
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(int anoFabricacao) { this.anoFabricacao = anoFabricacao; }
}

class Carro extends Veiculo {
    private static final double DESVALORIZACAO_ANUAL = 2000;

    public Carro(String placa, String marca, String modelo, int anoFabricacao) {
        super(placa, marca, modelo, anoFabricacao);
    }

    @Override
    public double calcularIPVA() {
        double valorEstimado = calcularValorEstimado();
        return valorEstimado * 0.04;
    }

    public double calcularValorEstimado() {
        int anosUso = 2023 - getAnoFabricacao(); // Trocar 2023 pelo ano atual
        return Math.max(0, 30000 - anosUso * DESVALORIZACAO_ANUAL); // Valor inicial fictício
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Carro - Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Ano: " + getAnoFabricacao() + ", IPVA: " + calcularIPVA());
    }
}

class Caminhao extends Veiculo {
    private static final double DESVALORIZACAO_ANUAL = 5000;

    public Caminhao(String placa, String marca, String modelo, int anoFabricacao) {
        super(placa, marca, modelo, anoFabricacao);
    }

    @Override
    public double calcularIPVA() {
        double valorEstimado = calcularValorEstimado();
        return valorEstimado * 0.015;
    }

    public double calcularValorEstimado() {
        int anosUso = 2023 - getAnoFabricacao(); // Trocar 2023 pelo ano atual
        return Math.max(0, 70000 - anosUso * DESVALORIZACAO_ANUAL); // Valor inicial fictício
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Caminhão - Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Ano: " + getAnoFabricacao() + ", IPVA: " + calcularIPVA());
    }
}

class Onibus extends Veiculo {
    private static final double DESVALORIZACAO_ANUAL = 3000;

    public Onibus(String placa, String marca, String modelo, int anoFabricacao) {
        super(placa, marca, modelo, anoFabricacao);
    }

    @Override
    public double calcularIPVA() {
        double valorEstimado = calcularValorEstimado();
        return valorEstimado * 0.02;
    }

    public double calcularValorEstimado() {
        int anosUso = 2023 - getAnoFabricacao(); // Trocar 2023 pelo ano atual
        return Math.max(0, 50000 - anosUso * DESVALORIZACAO_ANUAL); // Valor inicial fictício
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Ônibus - Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Ano: " + getAnoFabricacao() + ", IPVA: " + calcularIPVA());
    }
}

