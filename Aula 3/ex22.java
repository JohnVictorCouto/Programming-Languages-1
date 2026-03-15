import javax.swing.JOptionPane;

public class ex22 {
    public static void main(String[] args) {
        // Lê os 2 números
        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));

        // Identifica o menor e o maior
        int menor = (n1 < n2) ? n1 : n2;
        int maior = (n1 > n2) ? n1 : n2;
        
        // Mostra o resultado corretamente
        JOptionPane.showMessageDialog(null, "Quadrado do Menor: " + Math.pow(menor, 2) + "\nRaiz Quadrada do Maior: " + Math.sqrt(maior));
    }
}
