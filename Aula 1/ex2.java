/* Crie e teste, em Java, um algoritmo que leia 3 (três) palavras,
uma a uma, separadamente, e as apresente e tela, na ordem
contrária em que foram digitadas, numa única linha,
separadas por espaços */

import javax.swing.JOptionPane;

public class ex2 {
    public static void main(String[] args) {
        // Lê as entradas usando caixas de diálogo
        String palavra1 = JOptionPane.showInputDialog("Digite a primeira palavra:");
        String palavra2 = JOptionPane.showInputDialog("Digite a segunda palavra:");
        String palavra3 = JOptionPane.showInputDialog("Digite a terceira palavra:");

        // Monta o resultado
        String resultado = palavra3 + " " + palavra2 + " " + palavra1;

        // Exibe o resultado
        JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
    }
}