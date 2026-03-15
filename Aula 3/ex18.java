import javax.swing.JOptionPane; 

public class ex18 {

    public static void main(String[] args) {

        // Lê os 2 números
        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));

        // Verifica qual é o maior
        String resultado = (n1 != n2) ? "São diferentes" : "São Iguais" ;

        // Mostra o resultado
        JOptionPane.showMessageDialog(null, resultado);
    }
}