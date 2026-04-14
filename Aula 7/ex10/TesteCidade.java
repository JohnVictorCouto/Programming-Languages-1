import javax.swing.JOptionPane;
public class TesteCidade {
    public static void main(String[] args) {
        String nome = "São Caetano do Sul"; //Nome da cidade
        String estado = "SP"; //Estado da cidade
        int populacao =  165655; //População da cidade

        Cidade cidade = new Cidade(nome, estado, populacao); //Criação do objeto cidade

        JOptionPane.showMessageDialog(null, cidade.getdados()); //Exibe os dados da cidade
    }
}
