import javax.swing.JOptionPane;

public class ex15 {
    public static void main(String[] args) {
    // Lê o número digitado
    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));

    // Separa a dezena
    int dezena = (numero / 10) % 10;

    // Verificar se a dezena é par ou impar
    String resultado = (dezena % 2 == 0) ? "É par": "É ímpar";

    // Mostra o resultado
    JOptionPane.showMessageDialog(null, resultado);
}
}