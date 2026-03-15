import javax.swing.JOptionPane;

public class ex6 {
    public static void main(String[] args) {
       String string1 = JOptionPane.showInputDialog("Digite uma string: "); //Abre uma janela e pergunta uma string
       String string2 = JOptionPane.showInputDialog("Digite uma string: "); //Abre uma janela e pergunta uma string
       String string3 = JOptionPane.showInputDialog("Digite uma string: "); //Abre uma janela e pergunta uma string
       JOptionPane.showMessageDialog(null, "A soma do comprimento destas strings é "+(string1+string2+string3).length()); //Abre uma janela e mostra o resultado
    }
}
