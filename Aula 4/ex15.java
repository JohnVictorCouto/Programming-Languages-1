import javax.swing.JOptionPane;

public class ex15 {
    public static void main(String[] args) {
        double kwh;
        double totalResidencial = 0, totalComercial = 0, totalIndustrial = 0;
        double soma12 = 0;
        int cont12 = 0;

        while (true) {

            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do consumidor (0 para encerrar):"));
            if (codigo == 0) {
                break;
            }

            // Validação do kWh
            do {
                kwh = Double.parseDouble(JOptionPane.showInputDialog("Quantidade de kWh:"));
                if (kwh < 0) {
                    JOptionPane.showMessageDialog(null, "Valor inválido! Digite um valor positivo.");
                }
            } while (kwh < 0);

            // Validação do tipo
            int tipo;
            do {
                tipo = Integer.parseInt(JOptionPane.showInputDialog(
                        "Tipo (1-Residencial, 2-Comercial, 3-Industrial):"));
                if (tipo < 1 || tipo > 3) {
                    JOptionPane.showMessageDialog(null, "Tipo inválido!");
                }
            } while (tipo < 1 || tipo > 3);

            double preco = 0;

            switch (tipo) {
                case 1:
                    preco = 0.3;
                    totalResidencial += kwh;
                    soma12 += kwh;
                    cont12++;
                    break;

                case 2:
                    preco = 0.5;
                    totalComercial += kwh;
                    soma12 += kwh;
                    cont12++;
                    break;

                case 3:
                    preco = 0.7;
                    totalIndustrial += kwh;
                    break;
            }

            double custo = kwh * preco;
            JOptionPane.showMessageDialog(null, "Custo total: R$ " + custo);
        }

        double media = (cont12 > 0) ? (soma12 / cont12) : 0;

        String resultado = String.format("""
                === RESULTADOS ===
                Residencial: %.2f kWh
                Comercial: %.2f kWh
                Industrial: %.2f kWh
                Média (Tipos 1 e 2): %.2f kWh
                """,
                totalResidencial, totalComercial, totalIndustrial, media
        );

        JOptionPane.showMessageDialog(null, resultado);
    }
}