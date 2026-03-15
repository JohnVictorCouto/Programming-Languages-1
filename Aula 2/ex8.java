import javax.swing.JOptionPane;

public class ex8 {
    public static void main(String[] args) {
        double valorInicial = 100.00;
        double juros = 10;
        int meses = 8;
        double valorFinal = valorInicial * Math.pow((1+0.01*juros), meses);
        JOptionPane.showMessageDialog(null, "Depois de 8 meses, deverá ser pago " + String.format("%.2f", valorFinal)); 
    }
}
