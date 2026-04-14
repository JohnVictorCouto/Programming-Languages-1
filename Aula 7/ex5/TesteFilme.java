import javax.swing.JOptionPane;
public class TesteFilme {
    public static void main(String[] args) {
        String titulo = JOptionPane.showInputDialog("Digite o título do filme:"); //Solicita ao usuário que digite o título do filme e armazena na variável titulo
        String diretor = JOptionPane.showInputDialog("Digite o diretor do filme:"); //Solicita ao usuário que digite o diretor do filme e armazena na variável diretor
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento do filme:")); //Solicita ao usuário que digite o ano de lançamento do filme, converte a entrada para um inteiro e armazena na variável ano
        String genero = JOptionPane.showInputDialog("Digite o gênero do filme:"); //Solicita ao usuário que digite o gênero do filme e armazena na variável genero
        String indicacao = JOptionPane.showInputDialog("Digite faixa indicativa do filme:" + "\n L - Livre para todos os públicos" + "\n 10 - Não recomendado para menores de 10 anos" + "\n 12 - Não recomendado para menores de 12 anos" + "\n 14 - Não recomendado para menores de 14 anos" + "\n 16 - Não recomendado para menores de 16 anos" + "\n 18 - Não recomendado para menores de 18 anos"); //Solicita ao usuário que digite a faixa indicativa do filme, apresentando as opções disponíveis, e armazena na variável indicacao
        Filme filme = new Filme(titulo, diretor, ano, genero, indicacao); //Cria um objeto do tipo Filme utilizando os dados fornecidos pelo usuário
        JOptionPane.showMessageDialog(null, filme.toString()); //Exibe uma mensagem com as informações do filme utilizando o método toString() do objeto filme
    }
}
