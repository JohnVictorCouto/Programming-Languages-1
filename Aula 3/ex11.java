import javax.swing.JOptionPane;

public class ex11 {
    public static void main(String[] args) {
    // Lê o número digitado
    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));

    //Verificar se é multiplo de 3
    String resultado = (numero % 3 == 0) ? "É multiplo de 3" : "Não é multiplo de 3";

    // Mostra o resultado
    JOptionPane.showMessageDialog(null, resultado);
}
}