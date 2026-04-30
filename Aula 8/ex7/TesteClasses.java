public class TesteClasses {
    public static void main(String[] args) {
        // Criando um cachorro e um gato
        Cachorro cachorro = new Cachorro("Rex");
        Gato gato = new Gato("Mia");

        // Exibindo as informações dos animais
        System.out.println("Cachorro: " + cachorro.getNome() + ", Patas: " + cachorro.getPatas());
        System.out.println("Gato: " + gato.getNome() + ", Patas: " + gato.getPatas());
    }
}
