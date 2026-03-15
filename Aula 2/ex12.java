import javax.swing.JOptionPane; 

public class ex12 { 
    public static void main(String[] args) { 
        String a = JOptionPane.showInputDialog("Digite um numero (logaritmando):"); 
        String b = JOptionPane.showInputDialog("Digite um numero (base):"); 

        try {
            double logaritmando = Double.parseDouble(a);
            double base = Double.parseDouble(b);

            if (logaritmando > 0 && base > 0 && base != 1) { 
                double resultado = Math.log(logaritmando) / Math.log(base);
                JOptionPane.showMessageDialog(null, "Logaritmo: " + resultado); 
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Condições para o logaritmo inválidas (logaritmando > 0, base > 0, base != 1)."); 
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Digite números válidos.");
        }
    } 
}
