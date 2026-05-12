import javax.swing.JOptionPane;

public class AppBloco {
    public static void main(String[] args) {
        BlocoDeNotas bloco = new BlocoDeNotas(); // Instancia o bloco de notas
        
        // String que define o texto que aparecerá no menu principal
        String menu = "1) Inserir nota\n" +
                      "2) Remover nota\n" +
                      "3) Alterar nota\n" +
                      "4) Listar todas as notas\n" +
                      "5) Sair";

        int opcao = 0; // Variável para controlar a escolha do usuário

        // Loop que mantém o sistema rodando até o usuário escolher a opção 5 (Sair)
        while (opcao != 5) {
            // Abre janela de entrada de dados para ler a opção do menu
            String input = JOptionPane.showInputDialog(menu);
            
            // Se o usuário clicar em "Cancelar" ou fechar a janela, encerra o loop
            if (input == null) break; 

            try {
                // Converte o texto digitado (String) para número inteiro (int)
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Caso o usuário digite algo que não seja número, exibe erro e reinicia o loop
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
                continue;
            }

            // Estrutura de decisão baseada na opção escolhida
            switch (opcao) {
                case 1: // Inserir
                    String novaNota = JOptionPane.showInputDialog("Digite o texto da nota:");
                    bloco.inserir(novaNota); // Chama o método de inserção
                    break;

                case 2: // Remover
                    String listaRemover = bloco.listarNotas(); // Busca a lista atual
                    // Pede o índice e converte para inteiro
                    int idxRemover = Integer.parseInt(JOptionPane.showInputDialog(listaRemover + "\nDigite o índice para remover:"));
                    if (bloco.remover(idxRemover)) {
                        JOptionPane.showMessageDialog(null, "Nota removida!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Índice inválido!");
                    }
                    break;

                case 3: // Alterar
                    String listaAlterar = bloco.listarNotas();
                    int idxAlterar = Integer.parseInt(JOptionPane.showInputDialog(listaAlterar + "\nDigite o índice para alterar:"));
                    String novoTexto = JOptionPane.showInputDialog("Digite o novo texto:");
                    if (bloco.alterar(idxAlterar, novoTexto)) {
                        JOptionPane.showMessageDialog(null, "Nota alterada!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Índice inválido!");
                    }
                    break;

                case 4: // Listar
                    // Exibe todas as notas em uma caixa de mensagem
                    JOptionPane.showMessageDialog(null, bloco.listarNotas());
                    break;

                case 5: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break;

                default: // Opção fora de 1 a 5
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}