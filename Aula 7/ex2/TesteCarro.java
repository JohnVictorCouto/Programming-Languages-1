import javax.swing.JOptionPane;
public class TesteCarro {
    public static void main(String[] args) {
        String marca = JOptionPane.showInputDialog("Digite a marca do carro:"); //Solicita ao usuário que digite a marca do carro
        String modelo = JOptionPane.showInputDialog("Digite o modelo do carro:"); //Solicita ao usuário que digite o modelo do carro
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do carro:")); //Solicita ao usuário que digite o ano do carro e converte a entrada para um inteiro

        Carro carro1 = new Carro(marca, modelo, ano); //Cria um objeto da classe Carro usando os dados fornecidos pelo usuário

        JOptionPane.showMessageDialog(null, "Marca: " + carro1.getMarca() + "\nModelo: " + carro1.getModelo() + "\nAno: " + carro1.getAno()); //Exibe as informações do carro usando os métodos getMarca(), getModelo() e getAno()
    }
}
