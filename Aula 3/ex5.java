import javax.swing.JOptionPane; 

public class ex5 {

    public static void main(String[] args) {

        // Lê um número digitado pelo usuário
        double numero = Double.parseDouble(JOptionPane.showInputDialog("Digite um número"));

        double resultado = numero >= 0 ? Math.sqrt(numero) : numero * numero;

        // Mostra o resultado
        JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
    }
}