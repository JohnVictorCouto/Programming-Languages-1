public class Produto { //Classe Produto
    private String nome, validade; //Atributos privados para nome e validade do produto
    private int codigo; //Atributo privado para código
    private double preco; //Atributo privado para preço

    public Produto(String nome, int codigo, double preco, String validade) { //Construtor para Produto
        this.nome = nome; //Atribuição do nome
        this.codigo = codigo; //Atribuição do código
        this.preco = preco; //Atribuição do preço
        this.validade = validade; //Atribuição da validade
    }

    public String getNome() { //Método para obter o nome
        return nome; //Retorna o nome
    }
    public int getCodigo() { //Método para obter o código
        return codigo; //Retorna o código
    }
    public double getPreco() { //Método para obter o preço
        return preco; //Retorna o preço
    }
    public String getValidade() { //Método para obter a validade
        return validade; //Retorna a validade
    }
    public void setNome(String nome) { //Método para definir o nome
        this.nome = nome; //Atribuição do nome
    }
    public void setCodigo(int codigo) { //Método para definir o código
        this.codigo = codigo; //Atribuição do código
    }
    public void setPreco(double preco) { //Método para definir o preço
        this.preco = preco; //Atribuição do preço
    }
    public void setValidade(String validade) { //Método para definir a validade
        this.validade = validade; //Atribuição da validade
    }

    public String etiqueta() { //Método para gerar a etiqueta do produto
        return "Produto: " + nome + "\nCódigo: " + codigo + "\nPreço: R$ " + preco + "\nValidade: " + validade; //Retorna a etiqueta formatada
    }
}
