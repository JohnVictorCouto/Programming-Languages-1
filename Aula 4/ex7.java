import javax.swing.JOptionPane;

public class ex7 {
    public static void main(String[] args) {
        int N = Integer.parseInt(JOptionPane.showInputDialog("Quantos números quer realizar a média: ")); // Solicita ao usuário o número de valores para calcular a média e converte a entrada para um inteiro
        if (N <= 0) { // Verifica se o número de valores é menor ou igual a zero
            JOptionPane.showMessageDialog(null, "Número inválido. Por favor, digite um número positivo."); // Exibe uma mensagem de erro se o número for inválido
            N = Integer.parseInt(JOptionPane.showInputDialog("Quantos números quer realizar a média: ")); // Solicita novamente o número de valores para calcular a média
        }
        double soma = 0; // Inicializa a variável soma para acumular os valores
        for (int i = 0; i < N; i++) {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número positivo: ")); // Solicita ao usuário um número e converte a entrada para um double
            if (valor > 0) { // Verifica se o valor é positivo
                soma += valor; // Adiciona o valor à soma
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido. Por favor, digite um número positivo."); // Exibe uma mensagem de erro se o número não for positivo
                i--; // Decrementa i para repetir a iteração atual
            }
        }
        double media = soma / N; // Calcula a média
        JOptionPane.showMessageDialog(null, "A média é " + media); // Exibe a média em uma caixa de diálogo
    }
}
