import javax.swing.JOptionPane;

public class ex10 {
    public static void main(String[] args) {

        while (true) {

            double num = Double.parseDouble(JOptionPane.showInputDialog("Digite um número (-999 para parar):")); // Validação do número

            if (num == -999) { // Condição de parada
                break;
            }

            String resultado = ""; // Variável para armazenar os resultados

            // Raiz quadrada
            if (num >= 0) {
                double raiz = Math.sqrt(num); // Cálculo da raiz quadrada
                resultado += "Raiz quadrada: " + raiz + "\n"; // Adiciona o resultado da raiz quadrada à variável resultado
            } else {
                resultado += "Não existe raiz quadrada real para número negativo.\n"; // Mensagem para números negativos
            }

            // Inverso
            if (num != 0) {
                double inverso = 1 / num; // Cálculo do inverso
                resultado += "Inverso: " + inverso; // Adiciona o resultado do inverso à variável resultado
            } else {
                resultado += "Não existe inverso para zero."; // Mensagem para o número zero
            }

            JOptionPane.showMessageDialog(null, resultado); // Exibe os resultados para o usuário
        }
    }
}