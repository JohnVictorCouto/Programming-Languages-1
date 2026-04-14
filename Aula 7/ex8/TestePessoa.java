import javax.swing.JOptionPane;
public class TestePessoa {
    public static void main(String[] args) {
        String nome = "Aluno"; // Variável para armazenar o nome da pessoa
        int idade = 20;// Variável para armazenar a idade da pessoa
        double altura = 1.75;// Variável para armazenar a altura da pessoa
        Pessoa pessoa = new Pessoa(nome, idade, altura); // Cria um objeto da classe Pessoa usando o construtor e os valores das variáveis
        JOptionPane.showMessageDialog(null, pessoa.getdados()); // Exibe os dados da pessoa em uma caixa de diálogo
    }
}
