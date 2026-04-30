import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        PessoaFisica p = new PessoaFisica("João", "Silva", "111.111.111-11");
        JOptionPane.showMessageDialog(null, p.dados());

        Desempregado d = new Desempregado("Maria", "Souza", "222.222.222-22", 1500.00);
        JOptionPane.showMessageDialog(null, d.dados());

        Mensalista m = new Mensalista("Carlos", "Oliveira", "333.333.333-33", 3000);
        JOptionPane.showMessageDialog(null, m.dados() + "\nSalário: " + m.salario());

        Comissionado c = new Comissionado("Ana", "Costa", "444.444.444-44", 2000, 500);
        JOptionPane.showMessageDialog(null, c.dados() + "\nSalário: " + c.salario());
    }
}