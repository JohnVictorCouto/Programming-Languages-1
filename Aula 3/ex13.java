import javax.swing.JOptionPane;

public class ex13 {
    public static void main(String[] args) {
    // Lê o número digitado
    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));

    //Verificar se é divisível por 3 e por 7
    String resultado = (numero % 3 == 0) ? "É divisível por 3" : (numero % 7 == 0) ? "É divisível por 7" : "Não é divisível por 3 e por 7";

    // Mostra o resultado
    JOptionPane.showMessageDialog(null, resultado);
    }
}