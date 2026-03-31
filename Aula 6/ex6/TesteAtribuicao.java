import javax.swing.JOptionPane;

public class TesteAtribuicao {
    public static void main(String[] args) {

        // Entrada de dados do professor
        String nome = JOptionPane.showInputDialog("Digite o nome do professor:");
        
        int idade = Integer.parseInt(
                JOptionPane.showInputDialog("Digite a idade do professor:")
        );

        // Entrada de dados da disciplina
        String nomeDisciplina = JOptionPane.showInputDialog("Digite o nome da disciplina:");

        int resposta = JOptionPane.showConfirmDialog(
                null,
                "A disciplina é prática?",
                "Tipo de disciplina",
                JOptionPane.YES_NO_OPTION
        );

        boolean pratica = (resposta == JOptionPane.YES_OPTION);

        // Criando objetos com os dados do usuário
        Professor professor1 = new Professor(nome, idade);
        Disciplina disciplina1 = new Disciplina(nomeDisciplina, pratica);
        Atribuicao atribuicao1 = new Atribuicao(professor1, disciplina1);

        // Exibindo resultado
        JOptionPane.showMessageDialog(null, atribuicao1.getDados());
    }
}