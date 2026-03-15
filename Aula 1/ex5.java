/*Crie e teste, em Java, um algoritmo que leia, no formato real,
o peso e a altura do usuário, e depois apresente a tela:
“Seus dados digitados foram: <peso>kg e <altura>m” */

import javax.swing.JOptionPane;

public class ex5 {
    public static void main(String[] args) {
        // Lê a entrada usando caixas de diálogo
        String peso = JOptionPane.showInputDialog("Digite seu peso (Use . como separador):");
        // Lê a entrada usando caixas de diálogo
        String altura = JOptionPane.showInputDialog("Digite sua altura (Use . como separador):");
        // Converte a string para double e exibe o resultado
        JOptionPane.showMessageDialog(null, "Seus dados digitados foram: " + Double.parseDouble(peso) + " kg e " + Double.parseDouble(altura) + " m");
    }
}