import javax.swing.JOptionPane;

public class ex30 {

    public static void main(String[] args) {

        // Ler o nome do aluno
        String nome = JOptionPane.showInputDialog("Digite o nome do aluno").toUpperCase();

        // Pegar a primeira letra
        char letra = nome.charAt(0);

        // Verificar a divisão
        String divisao = (letra >= 'A' && letra <= 'K') ? "D1" :
                         (letra >= 'L' && letra <= 'N') ? "D2" :
                         (letra >= 'O' && letra <= 'Z') ? "D3" :
                         "Nome inválido";

        // Mostrar resultado
        JOptionPane.showMessageDialog(null, "Aluno: " + nome + "\nDivisão: " + divisao);
    }
}