import javax.swing.JOptionPane; 

public class ex3 {

    public static void main(String[] args) {

        // Lê o primeiro número digitado pelo usuário
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));

        // Lê o segundo número
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));

        // Calcula a soma dos dois números
        int soma = num1 + num2;

        String resultado = soma > 10 ? "Resultado: " + soma : "Resultado não é maior que 10";

        // Exibe a mensagem
        JOptionPane.showMessageDialog(null, resultado);
    }
}