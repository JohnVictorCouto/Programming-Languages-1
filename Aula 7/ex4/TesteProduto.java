import javax.swing.JOptionPane;
public class TesteProduto {
    public static void main(String[] args) {
        String nome = "Protetor Solar"; //Define o nome do produto
        int codigo = 1353632; //Solicita o código do produto e converte para inteiro
        double preco = 26.91; //Solicita o preço do produto e converte para double
        String validade = "2026-12-31"; //Define a validade do produto

        Produto produto1 = new Produto(nome, codigo, preco, validade); //Cria um objeto Produto com os dados fornecidos

        JOptionPane.showMessageDialog(null, produto1.etiqueta()); //Exibe a etiqueta do produto em uma caixa de diálogo
    }
}
