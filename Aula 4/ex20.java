import javax.swing.JOptionPane;

public class ex20 {
    public static void main(String[] args) {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro positivo:")); // Solicita ao usuário que digite um número inteiro positivo e converte a entrada para um inteiro

        while (n <= 0) { // Verifica se o número digitado é menor ou igual a 0, o que indica que é um número inválido para a sequência de Fibonacci
            JOptionPane.showMessageDialog(null, "Número inválido! Digite um número positivo."); // Exibe uma mensagem de erro caso o número seja inválido
            n = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro positivo:")); // Solicita novamente ao usuário que digite um número inteiro positivo e converte a entrada para um inteiro
        }

        int a = 1, b = 1; // Variáveis para armazenar os dois últimos números da sequência de Fibonacci, inicialmente definidas como 1 e 1

        String resultado = "Sequência de Fibonacci:\n"; 

        if (n >= 1) { // Verifica se n é maior ou igual a 1 para incluir o primeiro número da sequência de Fibonacci
            resultado += a + " "; // Adiciona o primeiro número da sequência de Fibonacci ao resultado
        }

        while (b <= n) { // Continua gerando números da sequência de Fibonacci enquanto o próximo número (b) for menor ou igual a n
            resultado += b + " "; // Adiciona o próximo número da sequência de Fibonacci ao resultado
            int prox = a + b; // Calcula o próximo número da sequência de Fibonacci como a soma dos dois últimos números (a e b)
            a = b; // Atualiza a para o valor de b, que é o último número gerado
            b = prox; // Atualiza b para o valor de prox, que é o próximo número da sequência de Fibonacci a ser gerado no próximo loop
        }

        JOptionPane.showMessageDialog(null, resultado); // Exibe a sequência de Fibonacci gerada em uma mensagem para o usuário
    }
}