public class Cliente { // Classe Cliente
    private String nome; // Atributo nome do cliente
    private String cpf; // Atributo CPF do cliente
    private ContaCorrente conta; // Atributo conta do cliente, do tipo ContaCorrente
    public Cliente(String nome, String cpf, ContaCorrente conta) { // Construtor da classe Cliente, que recebe o nome e CPF como parâmetros
        this.nome = nome; // Atribui os valores de nome e CPF aos atributos correspondentes
        this.cpf = cpf; // Atribui os valores de nome e CPF aos atributos correspondentes
        this.conta = conta; // Atribui a conta do cliente ao atributo correspondente
    }
    public String getNome() { // Método getter para o nome do cliente
        return nome;
    }
    public String getCpf() { // Método getter para o CPF do cliente
        return cpf;
    }
    public ContaCorrente getConta() { // Método getter para a conta do cliente
        return conta;
    }
    public void setConta(ContaCorrente conta) { // Método setter para a conta do cliente, que recebe uma instância de ContaCorrente como parâmetro
        this.conta = conta;
    }
    public void setNome(String nome) { // Método setter para o nome do cliente, que recebe uma string como parâmetro
        this.nome = nome;
    }
    public void setCpf(String cpf) { // Método setter para o CPF do cliente, que recebe uma string como parâmetro
        this.cpf = cpf;
    }
}
