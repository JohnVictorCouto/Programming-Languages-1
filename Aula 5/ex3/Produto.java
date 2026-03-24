import javax.swing.JOptionPane;
public class Produto {
    // Atributos privados
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor
    public Produto(String n, double p, int q) {
        nome = n;
        preco = p;
        quantidade = q;
    }

    // Métodos de Acesso (Getters) e Modificadores (Setters)
    public String getNome() { // getter para nome
        return nome; // retorna o valor do atributo nome
    }
    public void setNome(String n) { // setter para nome
        nome = n; // atribui o valor do parâmetro n ao atributo nome
    }
    public double getPreco() { // getter para preço
        return preco; // retorna o valor do atributo preco
    }
    public void setPreco(double p) { // setter para preço
        preco = p; // atribui o valor do parâmetro p ao atributo preco
    }
    public int getQuantidade() { // getter para quantidade
        return quantidade; // retorna o valor do atributo quantidade
    }
    public void setQuantidade(int q) { // setter para quantidade
        quantidade = q; // atribui o valor do parâmetro q ao atributo quantidade
    }

    // Método para exibir os dados do produto
    public void exibirDados() {
        JOptionPane.showMessageDialog(null, "--- Dados do Produto ---\nNome: " + nome + "\nPreço: R$ " + preco + "\nQuantidade: " + quantidade);
    }
}
