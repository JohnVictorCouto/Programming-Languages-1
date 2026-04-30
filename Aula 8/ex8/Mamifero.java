public class Mamifero extends Animal implements Lactante { // A classe Mamifero herda de Animal
    public Mamifero(String nome, int patas) { // Construtor que recebe nome e número de patas
        super(patas, nome); // Chama o construtor da classe pai (Animal) para inicializar os atributos
    }

    @Override
    public String produzirLeite() {
        return "Produz leite para alimentar os filhotes.";
    }
}