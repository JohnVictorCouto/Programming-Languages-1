import javax.swing.JOptionPane; 

public class ex9 {

    public static void main(String[] args) {

        // Lê o nome da pessoa
        String nome = JOptionPane.showInputDialog("Digite o nome");

        // Lê o sexo
        String sexo = JOptionPane.showInputDialog("Digite o sexo (F ou M)");

        // Lê a idade
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));

        // Verifica se é feminino e menor que 25
        String resultado =
                (sexo.equalsIgnoreCase("F") && idade < 25) ?
                nome + " - ACEITA" :
                nome + " - NÃO ACEITA";

        // Mostra o resultado
        JOptionPane.showMessageDialog(null, resultado);
    }
}