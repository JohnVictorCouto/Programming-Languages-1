/* Crie e teste, em Java, um algoritmo que leia 10 (dez)
caracteres, um a um, e imprima, de uma só vez, a palavra
formada pela união deles.*/

import javax.swing.JOptionPane;

public class ex6 {
    public static void main(String[] args) {
        // Armazenamento da palavra
        StringBuilder palavraFormada = new StringBuilder();

        // Laço de repetição para ler 10 caracteres
        for (int i = 0; i < 10; i++) {
            String entrada = JOptionPane.showInputDialog(null, 
                "Digite o " + (i + 1) + "º caractere:");

            if (entrada != null && entrada.length() > 0) {
                // charAt(0) pega o primeiro caractere digitado
                char caracter = entrada.charAt(0);
                palavraFormada.append(caracter);
            } 
        }

        // Imprime a palavra formada de uma só vez
        JOptionPane.showMessageDialog(null, "A palavra formada é: " + palavraFormada.toString());
    }
}
