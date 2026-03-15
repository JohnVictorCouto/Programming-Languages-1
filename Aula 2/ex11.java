import javax.swing.JOptionPane;

public class ex11 {
    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog("Digite um numero:");
        if (Double.parseDouble(numero) >= 0) {
            double logaritmando = Double.parseDouble(numero);
            JOptionPane.showMessageDialog(null, "Seno: " + Math.log10(logaritmando));
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }
}
