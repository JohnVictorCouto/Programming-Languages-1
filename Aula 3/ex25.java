import javax.swing.JOptionPane; 

public class ex25 {

    public static void main(String[] args) {

        // Lê os três números
        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));
        int n3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o terceiro número"));

        // Verifica qual é o menor
        int menor = (n1 < n2 && n1 < n3) ? n1 : (n2 < n3 ? n2 : n3);

        // Verifica qual é o maior
        int maior = (n1 > n2 && n1 > n3) ? n1 : (n2 > n3 ? n2 : n3);

        // Verifica qual é o intermediário
        int intermediario = (n1 != menor && n1 != maior) ? n1 : (n2 != menor && n2 != maior) ? n2 : n3;

        // Mostra os números em ordem crescente
        JOptionPane.showMessageDialog(null, "Maior: " + maior + "\nIntermediário: " + intermediario + "\nMenor: " + menor);
    }
}