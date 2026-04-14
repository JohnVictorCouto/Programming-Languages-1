import javax.swing.JOptionPane;
public class TesteFuncionario {
    public static void main(String[] args) {
        String nome = "Pessoa"; // Variável para armazenar o nome do funcionário
        String cargo = "Desenvolvedor Back-end"; // Variável para armazenar o cargo do funcionário
        double salario = 5000.0; // Variável para armazenar o salário do funcionário
        Funcionario funcionario = new Funcionario(nome, cargo, salario); // Criação de um objeto do tipo Funcionario
        JOptionPane.showMessageDialog(null, funcionario.getdados()); // Exibição dos dados do funcionário em uma janela de diálogo
    }
}
