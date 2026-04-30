public class Animal { // A classe Animal é a classe base (superclasse) para Mamifero, Gato e Cachorro
    private String nome; // Atributo para armazenar o nome do animal
    private int patas; // Atributo para armazenar o número de patas do animal

    public Animal() { // Construtor da classe Animal
    }

    public Animal(String nome) {
        this.nome = nome;
    }

    public Animal(int patas, String nome) {
        this.patas = patas;
        this.nome = nome;
    }

    // Getters e setters para acessar os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }
}