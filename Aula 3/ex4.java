import javax.swing.JOptionPane; 

public class ex4 {

    public static void main(String[] args) {

        // Lê o primeiro número
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));

        // Lê o segundo número
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));

        // Calcula a soma
        int soma = num1 + num2;

        int resultado = soma <= 20 ? soma - 5 : soma;

        // Mostra o resultado
        JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
    }
}