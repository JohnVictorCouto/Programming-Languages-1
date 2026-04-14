public class Pessoa { // Classe Pessoa
    private String nome; // Atributo nome
    private int idade; // Atributo idade
    private double altura; // Atributo altura

    public Pessoa(String nome, int idade, double altura) { // Construtor da classe Pessoa
        this.nome = nome; // Atribui o valor do parâmetro nome ao atributo nome
        this.idade = idade; // Atribui o valor do parâmetro idade ao atributo idade
        this.altura = altura; // Atribui o valor do parâmetro altura ao atributo altura
    }
    public String getNome() { // Método getter para o atributo nome
        return nome; // Retorna o valor do atributo nome
    }
    public int getIdade() { // Método getter para o atributo idade
        return idade; // Retorna o valor do atributo idade
    }
    public double getAltura() { // Método getter para o atributo altura
        return altura; // Retorna o valor do atributo altura
    }
    public void setNome(String nome) { // Método setter para o atributo nome
        this.nome = nome; // Atribui o valor do parâmetro nome ao atributo nome
    }
    public void setIdade(int idade) { // Método setter para o atributo idade
        this.idade = idade; // Atribui o valor do parâmetro idade ao atributo idade
    }
    public void setAltura(double altura) { // Método setter para o atributo altura
        this.altura = altura; // Atribui o valor do parâmetro altura ao atributo altura
    }
    public String getdados(){ // Método para retornar os dados da pessoa formatados
        return "Seja bem-vindo(a) \nNome: " + nome + "\nIdade: " + idade + "\nAltura: " + altura + " m"; // Retorna uma string formatada com os dados da pessoa
    }
}