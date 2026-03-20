import javax.swing.JOptionPane;

public class ex28 {
    public static void main(String[] args) {

        double preco;
        int quantidade;

        while (true) { // Loop infinito para permitir múltiplas entradas até que o usuário decida encerrar

            do { //Faça
                preco = Double.parseDouble(JOptionPane.showInputDialog("Preço unitário:")); //Entrada do preço unitário

                if (preco < 0) { // Se o preço for menor que 0, exibe mensagem de erro
                    JOptionPane.showMessageDialog(null, "Preço inválido! Digite um valor positivo."); // Exibe mensagem de erro para preço negativo
                }

            } while (preco < 0); // Condição de parada

            // Condição de parada
            if (preco == 0) {
                break;
            }

            do { //Faça
                quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:") ); //Entrada da quantidade

                if (quantidade < 0) { // Se a quantidade for menor que 0, exibe mensagem de erro
                    JOptionPane.showMessageDialog(null, "Quantidade inválida! Digite um valor positivo."); 
                }

            } while (quantidade < 0); // Enquanto quantidade menor que 0

            double total = preco * quantidade; // Cálculo do total a pagar

            JOptionPane.showMessageDialog(null, "Total: R$ " + total); // Exibe o total a pagar para o usuário
        }
    }
}