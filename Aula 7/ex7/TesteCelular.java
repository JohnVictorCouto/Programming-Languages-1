import javax.swing.JOptionPane;
public class TesteCelular {
    public static void main(String[] args) {
        Celular celular1 = new Celular("Samsung", "Galaxy S21", 128); // Cria um objeto celular1 da classe Celular com os valores "Samsung", "Galaxy S21" e 128 para marca, modelo e armazenamento, respectivamente
        JOptionPane.showMessageDialog(null, celular1.getdados()); // Exibe uma mensagem em uma caixa de diálogo com os dados do celular1, obtidos através do método getdados()
    }
}
