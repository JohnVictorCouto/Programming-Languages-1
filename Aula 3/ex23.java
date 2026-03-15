import javax.swing.JOptionPane; 

public class ex23 {

    public static void main(String[] args) {

        // Lê os três números
        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));
        int n3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o terceiro número"));

        // Verifica qual é o maior
        int maior = (n1 > n2 && n1 > n3) ? n1 : (n2 > n3 ? n2 : n3);

        // Mostra o maior
        JOptionPane.showMessageDialog(null, maior);
    }
}