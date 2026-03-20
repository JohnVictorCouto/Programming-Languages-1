import javax.swing.JOptionPane;

public class ex30 {
    public static void main(String[] args) {
        int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número:"));
        int option = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n1. Adição\n2. Subtração\n3. Multiplicação\n4. Divisão\n9. Sair do Programa \n Digite o número de ordem da opção desejada: "));
        while (option != 9) {
            switch (option) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Resultado da Adição: " + (a + b));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Resultado da Subtração: " + (a - b));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Resultado da Multiplicação: " + (a * b));
                    break;
                case 4:
                    if (b != 0) {
                        JOptionPane.showMessageDialog(null, "Resultado da Divisão: " + ((double) a / b));
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro: Divisão por zero não é permitida.");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
            }
            
            option = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n1. Adição\n2. Subtração\n3. Multiplicação\n4. Divisão\n9. Sair do Programa \n Digite o número de ordem da opção desejada: "));
        }
    }
}
