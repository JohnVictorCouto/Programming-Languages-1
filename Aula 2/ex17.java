import javax.swing.JOptionPane;

public class ex17 {
    public static void main(String[] args) {
        String raio = JOptionPane.showInputDialog("Raio:");
        double area = Math.PI * Math.pow(Double.parseDouble(raio), 2);
        JOptionPane.showMessageDialog(null, "A área é: " + area);
    }
}
