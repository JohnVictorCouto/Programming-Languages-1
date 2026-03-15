/* Crie e teste, em Java, um algoritmo que leia 4 (quatro)
números inteiros, um a um, de um único dígito cada,
representando, na ordem, milhar, centena, dezena e unidade.
Use o tipo caractere, para garantir que não seja digitado mais
de um número por vez. Após a concatenação desses números,
armazene-os em uma variável do tipo String. Apresente em
tela o valor final dessa String.
*/

import javax.swing.JOptionPane;

public class ex7 {
    public static void main(String[] args) {
        // Lê a entrada usando caixas de diálogo
        String milhar = JOptionPane.showInputDialog("Digite um milhar:");
        // Lê a entrada usando caixas de diálogo
        String centena = JOptionPane.showInputDialog("Digite uma centena:");
        // Lê a entrada usando caixas de diálogo
        String dezena = JOptionPane.showInputDialog("Digite uma dezena:");
        // Lê a entrada usando caixas de diálogo
        String unidade = JOptionPane.showInputDialog("Digite uma unidade:");
        // Armazenar o numero em string
        String resultado = "" + milhar.charAt(0)+centena.charAt(0)+dezena.charAt(0)+unidade.charAt(0);
        // Converte a string para char e exibe o resultado em string
        JOptionPane.showMessageDialog(null, resultado);
    }
}