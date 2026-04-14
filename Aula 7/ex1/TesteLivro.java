import javax.swing.JOptionPane;
public class TesteLivro {
    public static void main(String[] args) {
        String titulo = JOptionPane.showInputDialog("Digite o título do livro:"); // Solicitando ao usuário que insira as informações do livro usando caixas de diálogo
        String autor = JOptionPane.showInputDialog("Digite o autor do livro:"); // Solicitando ao usuário que insira as informações do livro usando caixas de diálogo
        int numeroPaginas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de páginas do livro:")); // Convertendo a entrada do usuário para um número inteiro
        String genero = JOptionPane.showInputDialog("Digite o gênero do livro:"); // Solicitando ao usuário que insira as informações do livro usando caixas de diálogo
        Livro livro = new Livro(titulo, autor, numeroPaginas, genero); // Criando um objeto da classe Livro com os dados fornecidos pelo usuário
        JOptionPane.showMessageDialog(null, "Título: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + "\nNúmero de Páginas: " + livro.getNumeroPaginas() + "\nGênero: " + livro.getGenero()); // Exibindo as informações do livro usando os métodos getters
    }   
}
