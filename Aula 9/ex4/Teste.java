import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        int opcao = 0;

        while (opcao != 6) {
            String menu = "1. Adicionar caixa\n2. Remover caixa\n3. Procurar caixa\n" +
                          "4. Mudar caixa\n5. Listar mais pesadas que 10.0\n6. Sair";
            
            String input = JOptionPane.showInputDialog(menu);
            if (input == null) break;
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    String dono = JOptionPane.showInputDialog("Nome do dono:");
                    String corr = JOptionPane.showInputDialog("Corredor:");
                    int pos = Integer.parseInt(JOptionPane.showInputDialog("Posição:"));
                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso:"));
                    deposito.adicionarCaixa(new Caixa(corr, pos, peso, dono));
                    break;

                case 2:
                    String donoRem = JOptionPane.showInputDialog("Dono da caixa a remover:");
                    if (deposito.removerCaixa(donoRem)) 
                        JOptionPane.showMessageDialog(null, "Removida!");
                    else 
                        JOptionPane.showMessageDialog(null, "Não encontrada.");
                    break;

                case 3:
                    String donoBusca = JOptionPane.showInputDialog("Dono para procurar:");
                    int p = deposito.encontrarPosicaoPorDono(donoBusca);
                    JOptionPane.showMessageDialog(null, (p != -1) ? "Posição no sistema: " + p : "Não encontrada.");
                    break;

                case 4:
                    String donoAlt = JOptionPane.showInputDialog("Dono da caixa para mudar:");
                    String nCorr = JOptionPane.showInputDialog("Novo corredor:");
                    int nPos = Integer.parseInt(JOptionPane.showInputDialog("Nova posição:"));
                    if (deposito.mudarCaixa(donoAlt, nCorr, nPos))
                        JOptionPane.showMessageDialog(null, "Alterado!");
                    else
                        JOptionPane.showMessageDialog(null, "Dono não encontrado.");
                    break;

                case 5:
                    Caixa[] pesadas = deposito.getCaixasPesadas(10.0);
                    StringBuilder lista = new StringBuilder("Caixas > 10kg:\n");
                    for (Caixa c : pesadas) lista.append(c.toString()).append("\n");
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;
            }
        }
    }
}