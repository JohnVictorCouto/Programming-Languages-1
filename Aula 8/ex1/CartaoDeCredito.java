public class CartaoDeCredito extends Pagamento { // Classe Cartao de Credito
    private String numeroDoCartao; // Atributo privado para numero do cartao
    public CartaoDeCredito(String nomeDoPagador, String cpf, double valorASerPago, String numeroDoCartao) { // Construtor da classe
        super(nomeDoPagador, cpf, valorASerPago); // Chamada do construtor da classe pai (Pagamento)
        this.numeroDoCartao = numeroDoCartao; // Atribuição do numero do cartao
    }
    public String getNumeroDoCartao() { // Método getter para numero do cartao
        return numeroDoCartao; // Retorna o numero do cartao
    }
    public void setNumeroDoCartao(String numeroDoCartao) { // Método setter para numero do cartao
        this.numeroDoCartao = numeroDoCartao; // Atribuição do numero do cartao
    }
}