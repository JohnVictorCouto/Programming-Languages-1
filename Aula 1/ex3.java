/*Crie e teste, em Java, um algoritmo que leia 1 (um) número
inteiro, armazene-o em uma variável do tipo inteiro, e depois
apresente em tela: */

import javax.swing.JOptionPane;

public class ex3 {
    public static void main(String[] args) {
        // Lê a entrada usando caixas de diálogo
        String valor = JOptionPane.showInputDialog("Digite um número inteiro:");
        // Converte a string para inteiro e exibe o resultado
        JOptionPane.showMessageDialog(null, "O valor do número digitado é: " + Integer.parseInt(valor));
    }
}