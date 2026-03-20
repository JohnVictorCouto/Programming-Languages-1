import javax.swing.JOptionPane; 

public class ex9 {
    public static void main(String[] args) {
        String resultado = ""; // Inicializa a variável resultado como uma string vazia
        while (true) { // loop infinito
            String entrada = JOptionPane.showInputDialog("Digite um nome (ou FIM para parar):"); // Solicita ao usuário um nome
            if (entrada.equalsIgnoreCase("FIM")) { // Verifica se o usuário deseja parar a entrada de nomes
                break; // Sai do loop
            }
            resultado += entrada + "\n"; // Adiciona o nome à variável resultado
        }
        JOptionPane.showMessageDialog(null, "Nomes digitados:\n" + resultado); // Exibe o resultado final em uma caixa de diálogo
    }
}