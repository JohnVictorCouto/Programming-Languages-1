public class ContaBancaria { //Classe Conta Bancária
    private int numeroConta; //Atributo para armazenar o número da conta
    private String nomeTitular; //Atributo para armazenar o nome do titular da conta
    private double saldo; //Atributo para armazenar o saldo da conta

    public ContaBancaria(int numeroConta, String nomeTitular, double saldo) { //Construtor da conta bancária
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public int getNumeroConta() { //Método para obter o número da conta
        return numeroConta;
    }
    public String getNomeTitular() { //Método para obter o nome do titular da conta
        return nomeTitular;
    }
    public double getSaldo() { //Método para obter o saldo da conta
        return saldo;
    }
    public void setNumeroConta(int numeroConta) { //Método para definir o número da conta
        this.numeroConta = numeroConta;
    }
    public void setNomeTitular(String nomeTitular) { //Método para definir o nome do titular da conta
        this.nomeTitular = nomeTitular;
    }
    public void setSaldo(double saldo) { //Método para definir o saldo da conta
        this.saldo = saldo;
    }
    public void depositar(double valor) { //Função para depositar dinheiro na conta, verificando se o valor é positivo
        if (valor > 0) {
            saldo += valor;
        }
    }
    public void sacar(double valor) { //Função para sacar dinheiro da conta, verificando se o valor é positivo e se há saldo suficiente
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        }
    }
}
