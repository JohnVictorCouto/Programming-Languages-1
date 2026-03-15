import javax.swing.JOptionPane;

public class ex22 {
    public static void main(String[] args) {
        try {
            // Entrada de dados
            String lado1S = JOptionPane.showInputDialog("Digite o valor do primeiro lado (b):");
            double b = Double.parseDouble(lado1S);

            String lado2S = JOptionPane.showInputDialog("Digite o valor do segundo lado (c):");
            double c = Double.parseDouble(lado2S);

            String anguloS = JOptionPane.showInputDialog("Digite o ângulo entre os lados em graus (A):");
            double anguloGraus = Double.parseDouble(anguloS);

            // Conversão de graus para radianos 
            double anguloRadianos = Math.toRadians(anguloGraus);

            // Aplicação da Lei dos Cossenos
            double aQuadrado = Math.pow(b, 2) + Math.pow(c, 2) - (2 * b * c * Math.cos(anguloRadianos));
            double a = Math.sqrt(aQuadrado);

            // Exibição do resultado formatado
            String resultado = String.format("O terceiro lado é: %.2f", a);
            JOptionPane.showMessageDialog(null, resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite apenas números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
