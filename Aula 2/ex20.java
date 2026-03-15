import javax.swing.JOptionPane;

public class ex20 {
    public static void main(String[] args) {
       String altura = JOptionPane.showInputDialog("Digite a altura: "); //Abre uma janela e pergunta sua altura
       String largura = JOptionPane.showInputDialog("Digite a largura: "); //Abre uma janela e pergunta sua largura
       JOptionPane.showMessageDialog(null, "A área do seu triangulo é " +Double.parseDouble(altura)*Double.parseDouble(largura)/2); //Abre uma janela e mostra o resultado
    }
}
