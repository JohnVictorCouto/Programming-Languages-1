import javax.swing.JOptionPane;
public class TesteProduto {
    public static void main(String[] args) {
        // 1. Pedir dados ao usuário
        String nome = JOptionPane.showInputDialog("""
                                                  Cadastro de Novo Produto
                                                  Nome do produto: """);
        String precoStr = JOptionPane.showInputDialog("Preço: R$ ");
        double preco = Double.parseDouble(precoStr);
        String qtdStr = JOptionPane.showInputDialog("Quantidade: ");
        int quantidade = Integer.parseInt(qtdStr);

        // 2. Criar objeto Produto
        Produto produto1 = new Produto(nome, preco, quantidade);

        // 3. Exibir dados
        JOptionPane.showMessageDialog(null, "Produto criado com sucesso!");
        produto1.exibirDados();
    }
}
