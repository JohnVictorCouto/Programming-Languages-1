import javax.swing.JOptionPane;

public class ex18 {
    public static void main(String[] args) {

        int num; // Variável para armazenar o número inteiro digitado pelo usuário
        int count = 0; // Variável para contar a quantidade de números primos digitados

        while (true) {

            num = Integer.parseInt(JOptionPane.showInputDialog( "Digite um número inteiro positivo (<= 0 para parar):")); // Solicita ao usuário que digite um número inteiro positivo e converte a entrada para um inteiro

            if (num <= 0) { // Verifica se o número é menor ou igual a 0, o que indica que o usuário deseja parar de digitar números
                break; // Encerra o loop se o número for menor ou igual a 0
            }

            boolean isPrimo = true; // Variável para indicar se o número é primo ou não, inicialmente assumida como verdadeira

            if (num == 1) { // O número 1 não é considerado primo
                isPrimo = false; // Define isPrimo como falso para o número 1
            } else { // Para números maiores que 1, verifica se são primos
                for (int i = 2; i <= Math.sqrt(num); i++) { // Verifica se o número é divisível por algum número entre 2 e a raiz quadrada de num
                    if (num % i == 0) { // Se num for divisível por i, então num não é primo
                        isPrimo = false; // Define isPrimo como falso se num for divisível por i
                        break; // Encerra o loop se num for divisível por i, pois já sabemos que não é primo
                    }
                }
            }

            if (isPrimo) { // Se isPrimo for verdadeiro, então num é um número primo
                count++; // Incrementa o contador de números primos se num for primo
            }
        }

        JOptionPane.showMessageDialog(null, "Quantidade de números primos digitados: " + count);
    }
}