import javax.swing.JOptionPane;

public class ex10 {
    public static void main(String[] args) {
        String angulo = JOptionPane.showInputDialog("Digite um angulo em graus:");
        if (angulo != null) {
            double anguloRadianos = Math.toRadians(Double.parseDouble(angulo));

            JOptionPane.showMessageDialog(null, "Seno: " + Math.sin(anguloRadianos));
            JOptionPane.showMessageDialog(null, "Cosseno: " + Math.cos(anguloRadianos));
            JOptionPane.showMessageDialog(null, "Tangente: " + Math.tan(anguloRadianos));
            JOptionPane.showMessageDialog(null, "Secante: " + (1 / Math.cos(anguloRadianos)));
            JOptionPane.showMessageDialog(null, "Cossecante: " + (1 / Math.sin(anguloRadianos)));
            JOptionPane.showMessageDialog(null, "Cotangente: " + (1 / Math.tan(anguloRadianos)));
        }
    }
}
