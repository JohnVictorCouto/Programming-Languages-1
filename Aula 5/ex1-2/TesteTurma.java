import javax.swing.JOptionPane;

public class TesteTurma {
    public static void main(String[] args) {

        // 1. Pedir dados ao usuário
        String nome = JOptionPane.showInputDialog("""
                                                  Cadastro de Nova Turma
                                                  Nome da turma: """);
        String curso = JOptionPane.showInputDialog("Curso: ");
        String serieStr = JOptionPane.showInputDialog("Série: ");
        int serie = Integer.parseInt(serieStr);
        String qtdAlunosStr = JOptionPane.showInputDialog("Quantidade de alunos: ");
        int qtdAlunos = Integer.parseInt(qtdAlunosStr);

        // 2. Criar objeto Turma
        Turma turma1 = new Turma(nome, curso, qtdAlunos, serie);

        // 3. Exibir dados
        JOptionPane.showMessageDialog(null, "Turma criada com sucesso!");
        turma1.exibirDados();

        // 4. Alterar quantidade de alunos
        String novaQtdStr = JOptionPane.showInputDialog("Digite a nova quantidade de alunos: ");
        int novaQtd = Integer.parseInt(novaQtdStr);
        turma1.setQuantidadeDeAlunos(novaQtd);

        // 5. Exibir dados novamente
        JOptionPane.showMessageDialog(null, "Dados atualizados:");
        turma1.exibirDados();
    }
}
