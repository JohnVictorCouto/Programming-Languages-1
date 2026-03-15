/*Crie e teste, em Java, um algoritmo que leia 3 (três) números,
separadamente, que representem uma data,
respectivamente, dia, mês e ano, e depois apresente a tela:
“A data digitada foi <DD>/<MM>/<AAAA>” */

import javax.swing.JOptionPane;

public class ex4 {
    public static void main(String[] args) {
        // Lê a entrada usando caixas de diálogo
        String dia = JOptionPane.showInputDialog("Digite um dia:");
        // Lê a entrada usando caixas de diálogo
        String mes = JOptionPane.showInputDialog("Digite um mes:");
        // Lê a entrada usando caixas de diálogo
        String ano = JOptionPane.showInputDialog("Digite um ano:");
        // Converte a string para inteiro e exibe o resultado
        JOptionPane.showMessageDialog(null, "A data digitada foi: " + Integer.parseInt(dia) + "/" + Integer.parseInt(mes) + "/" + Integer.parseInt(ano));
    }
}