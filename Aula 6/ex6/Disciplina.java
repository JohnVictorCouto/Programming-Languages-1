public class Disciplina {
    private String nome; // Atributo nome da disciplina
    private boolean pratica; // Atributo para indicar se a disciplina é prática ou teórica
    public Disciplina(String nome, boolean pratica) { // Construtor da classe Disciplina
        this.nome = nome; // Atribuição do nome da disciplina
        this.pratica = pratica; // Atribuição do tipo da disciplina (prática ou teórica)
    }
    public String getNome() { // Método para obter o nome da disciplina
        return nome;
    }
    public boolean getPratica() { // Método para verificar se a disciplina é prática
        return pratica;
    }
    public void setNome(String nome) { // Método para definir o nome da disciplina
        this.nome = nome;
    }
    public void setPratica(boolean pratica) { // Método para definir se a disciplina é prática ou teórica
        this.pratica = pratica;
    }
    public String getDados() { // Método para exibir os dados da disciplina
        String tipo = pratica ? "Prática" : "Teórica"; // Determina o tipo da disciplina
        return "Disciplina [nome=" + nome + ", tipo=" + tipo + "]"; // Retorna uma string com os dados da disciplina
    }
}
