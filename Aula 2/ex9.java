import javax.swing.JOptionPane;
public class ex9 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Digite um número inteiro de 5 dígitos:");
        int numero = Integer.parseInt(input);
        int algarismoDezena = (numero / 10) % 10;
        JOptionPane.showMessageDialog(null, "O algarismo da casa da dezena é: " + algarismoDezena);
    }
}