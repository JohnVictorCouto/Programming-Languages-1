import javax.swing.JOptionPane;

public class ex24 {
    public static void main(String[] args) {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o limite:")); // Solicita ao usuário que digite um número inteiro positivo para definir o limite da sequência de números a ser exibida e converte a entrada para um inteiro
        double step = Double.parseDouble(JOptionPane.showInputDialog("Digite o incremento:")); // Solicita ao usuário que digite um número inteiro positivo para definir o incremento entre os números da sequência e converte a entrada para um inteiro

        String resultado = ""; // Variável para armazenar a sequência de números a ser exibida, inicialmente definida como uma string vazia
        
        if (step <= 0) {
            JOptionPane.showMessageDialog(null, "O incremento deve ser maior que zero!");
            return;
        }

        for (int i = 0; i <= n; i += step) { // Loop que gera os números da sequência, começando em 0 e incrementando por step até atingir o limite n
            resultado += i + " "; // Adiciona o número i à variável resultado, seguido de um espaço para separar os números na sequência
        }

        JOptionPane.showMessageDialog(null, resultado); // Exibe a sequência de números gerada em uma mensagem para o usuário
    }
}