import javax.swing.JOptionPane;

public class CadastroApp {
    public static void main(String[] args) {
        BancoDeClientes banco = new BancoDeClientes();
        int opcao = 0;

        while (opcao != 6) {
            String menu = "1. Inserir Cliente\n" +
                          "2. Remover Cliente\n" +
                          "3. Alterar Cliente\n" +
                          "4. Listar um Cliente\n" +
                          "5. Listar Todos\n" +
                          "6. Sair";
            
            String entrada = JOptionPane.showInputDialog(menu);
            if (entrada == null) break;
            opcao = Integer.parseInt(entrada);

            switch (opcao) {
                case 1:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
                    String nome = JOptionPane.showInputDialog("Nome:");
                    String fone = JOptionPane.showInputDialog("Telefone:");
                    banco.inserir(new Cliente(id, nome, fone));
                    break;
                case 2:
                    int idRem = Integer.parseInt(JOptionPane.showInputDialog("ID para remover:"));
                    if (banco.remover(idRem)) JOptionPane.showMessageDialog(null, "Removido!");
                    else JOptionPane.showMessageDialog(null, "ID não encontrado.");
                    break;
                case 3:
                    int idAlt = Integer.parseInt(JOptionPane.showInputDialog("ID para alterar:"));
                    String nNome = JOptionPane.showInputDialog("Novo Nome:");
                    String nFone = JOptionPane.showInputDialog("Novo Fone:");
                    if (banco.alterar(idAlt, nNome, nFone)) JOptionPane.showMessageDialog(null, "Alterado!");
                    break;
                case 4:
                    int idBusca = Integer.parseInt(JOptionPane.showInputDialog("ID para buscar:"));
                    JOptionPane.showMessageDialog(null, banco.listarUm(idBusca));
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, banco.listarTodos());
                    break;
            }
        }
    }
}