public class ex13 {
    public static void main(String[] args) {
        int num = 100; // Inicializa a variável num com o valor 100
        int soma = 0; // Inicializa a variável soma com o valor 0
        for (int i = 1; i < num + 1; i++) {
            System.out.println(i + "\n"); // Imprime o valor de i seguido de uma nova linha
            soma += i; // Adiciona o valor de i à variável soma
        }
        System.out.println("A soma de todos os números de 1 a " + num + " é: " + soma); // Imprime a soma total dos números de 1 a num
    }
}