import javax.swing.JOptionPane;

public class ex14 {
    public static void main(String[] args) {
    // Lê o número digitado
    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));

    //Verificar se é divisível por 10, por 5, por 2
    String resultado = (numero % 10 == 0) ? "É divisível por 10" : (numero % 5 == 0) ? "É divisível por 5" : (numero % 2 == 0) ? "É divisível por 2" : "Não é divisível por nehum";

    // Mostra o resultado
    JOptionPane.showMessageDialog(null, resultado);
}
}