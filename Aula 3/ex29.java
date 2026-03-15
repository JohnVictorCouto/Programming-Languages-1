import javax.swing.JOptionPane;

public class ex29 {

    public static void main(String[] args) {

        // Lê o verbo
        String verbo = JOptionPane.showInputDialog("Digite um verbo no infinitivo").toLowerCase();

        // Verificação usando operador ternário
        String resultado = verbo.endsWith("ar") ? "1ª conjugação (verbo terminado em AR)" :
                           verbo.endsWith("er") ? "2ª conjugação (verbo terminado em ER)" :
                           verbo.endsWith("ir") ? "3ª conjugação (verbo terminado em IR)" :
                           (verbo.endsWith("or") || verbo.endsWith("ur")) ? "Provavelmente não é verbo no infinitivo" :
                           !verbo.endsWith("r") ? "Não está no infinitivo" :
                           "Verbo não identificado";

        // Mostra o resultado
        JOptionPane.showMessageDialog(null, resultado);
    }
}