import javax.swing.JOptionPane;

public class ex16 {
    public static void main(String[] args) {
        String a = JOptionPane.showInputDialog("Digite um numero para a:"); 
        String b = JOptionPane.showInputDialog("Digite um numero para b:"); 
        String c = JOptionPane.showInputDialog("Digite um numero para c:"); 
        double resultado = 2*((Double.parseDouble(a)-Double.parseDouble(c))/8)-Double.parseDouble(b)*5;
        JOptionPane.showMessageDialog(null, resultado);
    }
}
