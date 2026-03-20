import javax.swing.JOptionPane;
public class ex6 {
    public static void main(String[] args) {
        int num = 20; // Inicializa a variável num com o valor 20
        String resultado = ""; // Inicializa a variável resultado como uma string vazia
        for (int i = 0; i < num + 1; i++) {
            if (i % 2 == 0) { // Verifica se i é par
                resultado += i + "\n"; // Adiciona o número par à variável resultado seguido de uma nova linha
        }
    }
        JOptionPane.showMessageDialog(null, resultado); // Exibe a variável resultado em uma caixa de diálogo
    }
}
