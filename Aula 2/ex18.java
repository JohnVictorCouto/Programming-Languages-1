import javax.swing.JOptionPane;

public class ex18 {
    public static void main(String[] args) {
        try {
            // 1. Ler o dividendo
            String s1 = JOptionPane.showInputDialog("Digite o dividendo (inteiro):");
            int dividendo = Integer.parseInt(s1);

            // 2. Ler o divisor
            String s2 = JOptionPane.showInputDialog("Digite o divisor (inteiro):");
            int divisor = Integer.parseInt(s2);

            // 3. Verificar divisão por zero
            if (divisor == 0) {
                JOptionPane.showMessageDialog(null, "Erro: Divisão por zero não é permitida.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                // 4. Calcular quociente e resto
                int quociente = dividendo / divisor; 
                int resto = dividendo % divisor;     

                // 5. Exibir os resultados
                String mensagem = "Dividendo: " + dividendo +
                                  "\nDivisor: " + divisor +
                                  "\nQuociente: " + quociente +
                                  "\nResto: " + resto;
                
                JOptionPane.showMessageDialog(null, mensagem, "Resultado da Divisão", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite apenas números inteiros válidos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
