import javax.swing.JOptionPane;
public class TesteDisciplina {
    public static void main(String[] args) {
        // 1. Pedir dados ao usuário
        String nome = JOptionPane.showInputDialog("""
                                                  Cadastro de Nova Disciplina
                                                  Nome da disciplina: """);
        String professor = JOptionPane.showInputDialog("Professor: ");
        int semestre = Integer.parseInt(JOptionPane.showInputDialog("Semestre: "));
        boolean ofertada = JOptionPane.showConfirmDialog(null, "A disciplina está sendo ofertada neste semestre?", "Oferta da Disciplina", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        

        // 2. Criar objeto Disciplina
        Disciplina disciplina1 = new Disciplina(nome, professor, semestre, ofertada);

        // 3. Exibir dados
        JOptionPane.showMessageDialog(null, "Disciplina criada com sucesso!");
        disciplina1.exibirDados();
    }
}
