import javax.swing.JOptionPane;

public class ex16 {
    public static void main(String[] args) {
    // Lê o número digitado
    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número de 4 digitos"));

    // Separa algarismos
    int milhares = numero / 1000;
    int centenas = (numero % 1000) / 100;

    // Numero formado por milhares e centenas
    int valor = Integer.parseInt(Integer.toString(milhares) + Integer.toString(centenas));

    // Verificar se a dezena é par ou impar
    String resultado = (valor % 4 == 0) ? "É multiplo de 4": "Não é multiplo de 4";

    // Mostra o resultado
    JOptionPane.showMessageDialog(null, resultado);
}
}