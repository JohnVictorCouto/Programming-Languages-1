import javax.swing.JOptionPane;

public class ex17 {
    public static void main(String[] args) {

        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:")); // Solicita ao usuário que digite um número inteiro e converte a entrada para um inteiro

        while (num < 0) { // Verifica se o número é negativo
            JOptionPane.showMessageDialog(null, "Número inválido! Digite um número inteiro positivo."); // Exibe uma mensagem de erro se o número for negativo
            num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:")); // Solicita novamente ao usuário que digite um número inteiro e converte a entrada para um inteiro
        }

        boolean isPrimo = true; // Variável para indicar se o número é primo ou não, inicialmente assumida como verdadeira

        if (num <= 1) { // Números menores ou iguais a 1 não são primos
            isPrimo = false; // Define isPrimo como falso para números menores ou iguais a 1
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) { // Verifica se o número é divisível por algum número entre 2 e a raiz quadrada de num
                if (num % i == 0) { // Se num for divisível por i, então num não é primo
                    isPrimo = false; // Define isPrimo como falso se num for divisível por i
                    break; // Encerra o loop se num for divisível por i, pois já sabemos que não é primo
                }
            }
        }
 
        if (isPrimo) { // Se isPrimo for verdadeiro, então num é um número primo
            JOptionPane.showMessageDialog(null, num + " é um número primo."); // Exibe uma mensagem indicando que num é um número primo
        } else { // Se isPrimo for falso, então num não é um número primo
            JOptionPane.showMessageDialog(null, num + " não é um número primo."); // Exibe uma mensagem indicando que num não é um número primo
        }
    }
}