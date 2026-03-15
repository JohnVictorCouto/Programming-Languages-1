import javax.swing.JOptionPane; 

public class ex8 {

    public static void main(String[] args) {

        // Lê o número digitado
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));

        // Verificar as condições
        String resultado =
                numero > 20 ? "Maior que 20" :
                numero == 20 ? "Igual a 20" :
                "Menor que 20";

        // Exibe o resultado
        JOptionPane.showMessageDialog(null, resultado);
    }
}