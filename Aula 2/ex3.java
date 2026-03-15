import javax.swing.JOptionPane;

public class ex3 {
    public static void main(String[] args) {
       String idade = JOptionPane.showInputDialog("Digite sua idade: "); //Abre uma janela e pergunta sua idade
       JOptionPane.showMessageDialog(null, "Viveu "+ Integer.parseInt(idade)*365 + " dias"); //Abre uma janela e mostra o resultado
    }
}
