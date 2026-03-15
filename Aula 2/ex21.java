import javax.swing.JOptionPane;

public class ex21 {
    public static void main(String[] args) {
       String diaMaior = JOptionPane.showInputDialog("Digite o maior diametro: "); //Abre uma janela e pergunta o diametro maior
       String diaMenor = JOptionPane.showInputDialog("Digite o menor diametro: "); //Abre uma janela e pergunta o diametro menor
       JOptionPane.showMessageDialog(null, "A área do seu retangulo é " +Double.parseDouble(diaMaior)*Double.parseDouble(diaMenor)/2); //Abre uma janela e mostra o resultado
    }
}
