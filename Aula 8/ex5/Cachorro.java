public class Cachorro extends Mamifero { // A classe Cachorro herda de Mamifero
    public Cachorro(String nome) { // Construtor que recebe o nome do cachorro
        super(nome, 4); // Cachorros geralmente têm 4 patas, então passamos 4 para o construtor da classe pai (Mamifero)
    }
}