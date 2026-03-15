import javax.swing.JOptionPane;

public class ex7 {

    public static void main(String[] args) {

        // Lê um número digitado
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));

        // Verificar o intervalo
        String resultado = (numero >= 20 && numero <= 90) ?
                "O número está entre 20 e 90" :
                "O número NÃO está entre 20 e 90";

        // Mostra o resultado
        JOptionPane.showMessageDialog(null, resultado);
    }
}