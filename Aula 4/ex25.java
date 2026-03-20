import javax.swing.JOptionPane;

public class ex25 {
    public static void main(String[] args) {
        int n = 20; // Define o número de pessoas a serem cadastradas, neste caso, 20
        String resultado = ""; // Variável para armazenar os nomes dos homens com 21 anos ou mais, inicialmente definida como uma string vazia

        for (int i = 1; i <= n; i += 1) { // Loop que se repete n vezes, solicitando ao usuário que digite o nome, idade e sexo de cada pessoa
            String nome = JOptionPane.showInputDialog("Digite o nome:"); // Solicita ao usuário que digite o nome da pessoa e armazena a entrada na variável nome
            
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:")); // Solicita ao usuário que digite a idade da pessoa, converte a entrada para um inteiro e armazena na variável idade
            
            String sexo = JOptionPane.showInputDialog("Digite o sexo (M/F):"); // Solicita ao usuário que digite o sexo da pessoa (M para masculino e F para feminino) e armazena a entrada na variável sexo

            if ((sexo.equalsIgnoreCase("M") && idade >= 21)) { // Verifica se o sexo é masculino e se a idade é maior ou igual a 21 anos
                resultado += nome + "\n";  // Se a condição for verdadeira, adiciona o nome da pessoa à variável resultado, seguido de uma nova linha para separar os nomes na exibição final
            }
        }

        JOptionPane.showMessageDialog(null, resultado); // Exibe os nomes dos homens com 21 anos ou mais em uma mensagem para o usuárioA
    }
}
