import javax.swing.JOptionPane;

public class ex26 {
    public static void main(String[] args) {
        // Lê os cinco números
        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));
        int n3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o terceiro número"));
        int n4 = Integer.parseInt(JOptionPane.showInputDialog("Digite o quarto número"));
        int n5 = Integer.parseInt(JOptionPane.showInputDialog("Digite o quinto número"));

        // Encontrar o maior 
        int maior = (n1 >= n2) ? n1 : n2;
        maior = (maior >= n3) ? maior : n3;
        maior = (maior >= n4) ? maior : n4;
        maior = (maior >= n5) ? maior : n5;

        // Encontrar o menor
        int menor = (n1 <= n2) ? n1 : n2;
        menor = (menor <= n3) ? menor : n3;
        menor = (menor <= n4) ? menor : n4;
        menor = (menor <= n5) ? menor : n5;

        // Mostra o maior e o menor
        JOptionPane.showMessageDialog(null, "Maior: " + maior + "\nMenor: " + menor);
    }
}
