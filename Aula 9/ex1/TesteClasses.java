import javax.swing.JOptionPane;
public class TesteClasses {
    public static void main(String[] args) {
        // 1. Entrada de dados comuns
        String nome = JOptionPane.showInputDialog("Nome:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));
        String cargo = JOptionPane.showInputDialog("Cargo:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salário:"));

        // 2. Lógica do booleano ehAposentado
        int resp = JOptionPane.showConfirmDialog(null, "É aposentado?", "Status", JOptionPane.YES_NO_OPTION);
        boolean ehAposentado = (resp == JOptionPane.YES_OPTION);

        if (ehAposentado) {
            double salApo = Double.parseDouble(JOptionPane.showInputDialog("Salário Aposentadoria:"));
            
            // Instância da Subclasse
            FuncionarioAposentado fa = new FuncionarioAposentado(nome, idade, salario, cargo, true, salApo);
            
            // Exibição com Polimorfismo
            JOptionPane.showMessageDialog(null, "Aposentado: " + fa.getNome() + 
                "\nCategoria: " + fa.categoria(idade) + 
                "\nTotal: " + (fa.getSalario() + fa.getSalarioAposentadoria()));
        } else {
            // Instância da Classe Base
            Funcionario f = new Funcionario(nome, idade, salario, cargo, false);
            
            JOptionPane.showMessageDialog(null, "Funcionário: " + f.getNome() + 
                "\nCategoria: " + f.categoria(idade) + 
                "\nSalário: " + f.getSalario());
        }
    }
}
