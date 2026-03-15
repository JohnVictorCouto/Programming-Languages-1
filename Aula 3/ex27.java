import javax.swing.JOptionPane;

public class ex27 {

    public static void main(String[] args) {

        // Lê os três números
        int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));
        int c = Integer.parseInt(JOptionPane.showInputDialog("Digite o terceiro número"));

        // Verificar se podem formar um triangulo
        String resultado = (a < b + c) && (b < a + c) && (c < a + b) ? "Forma um triangulo" : "Não forma um triangulo";

        // Mostra o resultado
        JOptionPane.showMessageDialog(null, resultado);
    }
}