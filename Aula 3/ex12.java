import javax.swing.JOptionPane;

public class ex12 {
    public static void main(String[] args) {
    // Lê o número digitado
    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));

    //Verificar se é divisível por 5
    String resultado = (numero % 5 == 0) ? "É divisível por 5" : "Não é divisível por 5";

    // Mostra o resultado
    JOptionPane.showMessageDialog(null, resultado);
    }
}
