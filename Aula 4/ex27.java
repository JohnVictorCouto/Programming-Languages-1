import javax.swing.JOptionPane;

public class ex27 {
    public static void main(String[] args) {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o limite:")); // Solicita ao usuário que digite um número inteiro positivo para definir o limite da sequência de números a ser exibida e converte a entrada para um inteiro

        String resultado = " "; // Variável para armazenar a sequência de números a ser exibida, inicialmente definida como uma string vazia
        
        for (int i = 1; i <= n; i += 1) { // Loop que gera os números da sequência, começando em 1 e incrementando por 1 até atingir o limite n
            resultado += 2*i + " "; // Adiciona o número 2*i à variável resultado, seguido de um espaço para separar os números na sequência, gerando assim a sequência de números pares
        }

        JOptionPane.showMessageDialog(null, resultado); // Exibe a sequência de números gerada em uma mensagem para o usuário
    }
}