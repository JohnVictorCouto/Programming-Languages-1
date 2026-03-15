import javax.swing.JOptionPane;

public class ex5 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Digite um número inteiro:"); //Abre uma janela e pergunta um valor real
        JOptionPane.showMessageDialog(null, "O quadrado de " + Double.parseDouble(input) + " é " + Math.pow(Double.parseDouble(input), 2)); //Mostra o resultado, com a conta de exponencia realizada pela função Math.pow
    }
}