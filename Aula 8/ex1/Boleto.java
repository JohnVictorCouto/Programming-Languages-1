public class Boleto extends Pagamento { //Classe Boleto
    private String numeroDoBoleto; // Atributo privado para numero do boleto
    private int dia, mes, ano; // Atributos privados para dia, mes e ano
    public Boleto(String nomeDoPagador, String cpf, double valorASerPago, String numeroDoBoleto, int dia, int mes, int ano) { // Construtor da classe
        super(nomeDoPagador, cpf, valorASerPago); // Chamada do construtor da classe pai (Pagamento)
        this.numeroDoBoleto = numeroDoBoleto; // Atribuição do numero do boleto
        this.dia = dia; // Atribuição do dia
        this.mes = mes; // Atribuição do mes
        this.ano = ano; // Atribuição do ano
    }
    public String getNumeroDoBoleto() { // Método getter para numero do boleto
        return numeroDoBoleto; // Retorna o numero do boleto
    }
    public void setNumeroDoBoleto(String numeroDoBoleto) { // Método setter para numero do boleto
        this.numeroDoBoleto = numeroDoBoleto; // Atribuição do numero do boleto
    }
    public int getDia() { // Método getter para dia
        return dia; // Retorna o dia
    }
    public void setDia(int dia) { // Método setter para dia
        this.dia = dia; // Atribuição do dia
    }
    public int getMes() { // Método getter para mes
        return mes; // Retorna o mes
    }
    public void setMes(int mes) { // Método setter para mes
        this.mes = mes; // Atribuição do mes
    }
    public int getAno() { // Método getter para ano
        return ano; // Retorna o ano
    }
    public void setAno(int ano) { // Método setter para ano
        this.ano = ano; // Atribuição do ano
    }
}
