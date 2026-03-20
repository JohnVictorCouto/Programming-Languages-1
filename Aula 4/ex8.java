import javax.swing.JOptionPane; 

public class ex8 {
    public static void main(String[] args) {
        int count = 0; // contador de números entre 100 e 200
        while (true) { // loop infinito
            int entrada = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro (ou 0 para parar):")); // Solicita ao usuário um número inteiro e converte a entrada para um inteiro
            if (entrada == 0) { // Verifica se o usuário deseja parar a entrada de números
                break; // Sai do loop
            }
            if (entrada >= 100 && entrada <= 200) { // Verifica se o número está entre 100 e 200
                count++; // Incrementa o contador se o número estiver entre 100 e 200
            }
        }
        JOptionPane.showMessageDialog(null, "Foram digitados entre 100 e 200: " + count); // Exibe o resultado final em uma caixa de diálogo
    }
}