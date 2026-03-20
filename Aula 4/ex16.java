import javax.swing.JOptionPane;
public class ex16 {
    public static void main(String[] args) {
        int count1 = 0, count2 = 0; // Contadores para menores de 21 anos e maiores de 50 anos
        while (true) { // Loop infinito
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:")); // Solicita a idade do usuário e converte para inteiro
            if (idade < 0 || idade > 120) { // Verifica se a idade é válida
                JOptionPane.showMessageDialog(null, "Idade inválida! Encerrando o programa.");
                break;
            }
            if (idade < 21) { // Incrementa o contador de pessoas com menos de 21 anos
                count1++;
            } else if (idade > 50) { // Incrementa o contador de pessoas com mais de 50 anos
                count2++;
            }
        }
        JOptionPane.showMessageDialog(null, "Pessoas com menos de 21 anos: " + count1); // Exibe o número de pessoas com menos de 21 anos
        JOptionPane.showMessageDialog(null, "Pessoas com mais de 50 anos: " + count2); // Exibe o número de pessoas com mais de 50 anos
    }
}
