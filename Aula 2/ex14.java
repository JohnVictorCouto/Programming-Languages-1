import javax.swing.JOptionPane;

public class ex14 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Entre com a data no formato dd/mm/aaaa:");

        int dataInteiro = Integer.parseInt(input);

        int dia = dataInteiro / 1000000;         
        int mes = (dataInteiro % 1000000) / 10000; 
        int ano = dataInteiro % 10000;           

        String mensagem = "Data: " + input + "\n" +
                          "Dia: " + dia + "\n" +
                          "Mês: " + mes + "\n" +
                          "Ano: " + ano; 

        JOptionPane.showMessageDialog(null, mensagem);
    }
}