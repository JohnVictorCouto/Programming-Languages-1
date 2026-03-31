public class Professor { // Classe Professor
    private String nome; // Atributo nome do professor
    private int idade; // Atributo idade do professor
    public Professor(String nome, int idade) { // Construtor da classe Professor
        this.nome = nome; // Atribuição do nome do professor
        this.idade = idade; // Atribuição da idade do professor
    }
    public String getNome() { // Método para obter o nome do professor
        return nome;
    }
    public int getIdade() { // Método para obter a idade do professor
        return idade;
    }
    public void setNome(String nome) { // Método para definir o nome do professor
        this.nome = nome;
    }
    public void setIdade(int idade) { // Método para definir a idade do professor
        this.idade = idade;
    }
    public String getDados() { // Método para exibir os dados do professor
       return "Professor [nome=" + nome + ", idade=" + idade + "]"; // Retorna uma string com os dados do professor
    }
}
