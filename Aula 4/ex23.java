import javax.swing.JOptionPane;

public class ex23 {
    public static void main(String[] args) {

        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro não negativo:")); // Solicita ao usuário que digite um número inteiro não negativo e converte a entrada para um inteiro

        if (num < 0) { // Verifica se o número digitado é negativo, o que indica que o fatorial não existe para números negativos
            JOptionPane.showMessageDialog(null, "Fatorial não existe para números negativos."); // Exibe uma mensagem indicando que o fatorial não existe para números negativos
            return; // Encerra o programa se o número for negativo
        }

        int fatorial = 1; // Variável para armazenar o resultado do fatorial, inicialmente definida como 1 (fatorial de 0 é 1)

        for (int i = 2; i <= num; i++) { // Loop que calcula o fatorial multiplicando os números de 2 até num (inclusive)
            fatorial *= i; // Multiplica fatorial pelo número i em cada iteração do loop para calcular o fatorial de num
        }

        JOptionPane.showMessageDialog( null, "O fatorial de " + num + " é: " + fatorial); // Exibe o resultado do fatorial em uma mensagem para o usuário
    }
}