public class Pagamento { // Classe Pagamento
    private String nomeDoPagador, cpf; // Atributos privados para nome do pagador e cpf
    private double valorASerPago; // Atributo privado de valor a ser pago
    public Pagamento(String nomeDoPagador, String cpf, double valorASerPago) { // Construtor da classe
        this.nomeDoPagador = nomeDoPagador; // Atribuição do nome do pagador
        this.cpf = cpf; // Atribuição do cpf
        this.valorASerPago = valorASerPago; // Atribuição do valor a ser pago
    }
    public String getNomeDoPagador() { // Método getter para nome do pagador
        return nomeDoPagador; // Retorna o nome do pagador
    }
    public String getCpf() { // Método getter para cpf
        return cpf; // Retorna o cpf
    }
    public double getValorASerPago() { // Método getter para valor a ser pago
        return valorASerPago; // Retorna o valor a ser pago
    }
    public void setNomeDoPagador(String nomeDoPagador) { // Método setter para nome do pagador
        this.nomeDoPagador = nomeDoPagador; // Atribuição do nome do pagador
    }
    public void setCpf(String cpf) { // Método setter para cpf
        this.cpf = cpf; // Atribuição do cpf
    }
    public void setValorASerPago(double valorASerPago) { // Método setter para valor a ser pago
        this.valorASerPago = valorASerPago; // Atribuição do valor a ser pago
    }
}
