import javax.swing.JOptionPane;
public class ex19 {
    public static void main(String[] args) {
      int maior = 0; // Variável para armazenar o maior número digitado, inicialmente definida como 0   
      while (true) { 
            int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro (-9999 para parar):")); // Solicita ao usuário que digite um número inteiro e converte a entrada para um inteiro
            if (num == -9999) { // Verifica se o número é -9999, o que indica que o usuário deseja parar de digitar números
                break; // Encerra o loop se o número for -9999
            }
            if (num > maior) { // Verifica se o número digitado é maior do que o valor armazenado em maior
                maior = num; // Atualiza o valor de maior para o número digitado, se for maior
            }
      }
        JOptionPane.showMessageDialog(null, "O maior número digitado foi: " + maior); // Exibe uma mensagem indicando qual foi o maior número digitado
    }
}
