import javax.swing.JOptionPane; 

public class ex19 {

    public static void main(String[] args) {

        // Lê os 2 números
        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));

        // Verifica qual é o menor
        int menor = (n1 < n2) ? n1 : n2 ;

        // Mostra o menor
        JOptionPane.showMessageDialog(null, menor);
    }
}