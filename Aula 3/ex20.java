import javax.swing.JOptionPane; 

public class ex20 {

    public static void main(String[] args) {

        // Lê os 2 números
        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));

        // Verifica qual é o menor
        int menor = (n1 < n2) ? n1 : n2;

        // Verifica qual é o maior
        int maior = (n1 > n2) ? n1 : n2 ;

        // Mostra os números em ordem crescente
        JOptionPane.showMessageDialog(null, "" + menor + ", " + maior);
    }
}