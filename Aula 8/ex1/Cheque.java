public class Cheque extends Pagamento { // Classe Cheque
    private String numeroDoCheque; // Atributo privado para numero do cheque
    public Cheque(String nomeDoPagador, String cpf, double valorASerPago, String numeroDoCheque){
        super(nomeDoPagador, cpf, valorASerPago); // Chamada do construtor da classe pai (Pagamento)
        this.numeroDoCheque = numeroDoCheque; // Atribuição do numero do Cheque
    }
    public String getNumeroDoCheque() { // Método getter para numero do cheque
        return numeroDoCheque; // Retorna o numero do cheque
    }
    public void setNumeroDoCheque(String numeroDoCheque) { // Método setter para numero do cheque
        this.numeroDoCheque = numeroDoCheque; // Atribuição do numero do cheque
    }
}
