public class PessoaFisica {
    private String nome;
    private String sobrenome;
    private String cpf;

    // Construtor sem parâmetros
    public PessoaFisica() {
        this.nome = "Sem nome";
        this.sobrenome = "Sem sobrenome";
        this.cpf = "000.000.000-00";
    }

    // Construtor com parâmetros
    public PessoaFisica(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Método dados()
    public String dados() {
        return "Nome: " + nome +
               "\nSobrenome: " + sobrenome +
               "\nCPF: " + cpf;
    }
}