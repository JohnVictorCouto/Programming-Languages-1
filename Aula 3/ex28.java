import javax.swing.JOptionPane;

public class ex28 {

    public static void main(String[] args) {

        // Lê os três números
        int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));
        int c = Integer.parseInt(JOptionPane.showInputDialog("Digite o terceiro número"));

        // Verificar se podem formar um triangulo e seu tipo
        String resultado = (a < b + c) && (b < a + c) && (c < a + b) ? ((a == b && b == c) ? "Equilatero" : (a == b || a == c || b == c) ? "Isósceles" : "Escaleno") : "Não forma um triangulo";

        // Mostra o resultado
        JOptionPane.showMessageDialog(null, resultado);
    }
}