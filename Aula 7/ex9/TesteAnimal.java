import javax.swing.JOptionPane;
public class TesteAnimal {
    public static void main(String[] args) {
        String nome1 = JOptionPane.showInputDialog("Digite o nome do animal:"); // Solicita ao usuário que digite o nome do animal
        String especie1 = JOptionPane.showInputDialog("Digite a espécie do animal:"); // Solicita ao usuário que digite a espécie do animal
        int idade1 = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do animal:")); // Solicita ao usuário que digite a idade do animal e converte para inteiro
        Animal animal1 = new Animal(nome1, especie1, idade1); // Cria um objeto da classe Animal com os dados fornecidos pelo usuário
        JOptionPane.showMessageDialog(null, "Nome: " + animal1.getNome() + "\nEspécie: " + animal1.getEspecie() + "\nIdade: " + animal1.getIdade()); // Exibe as informações do animal em uma caixa de diálogo
        String nome2 = JOptionPane.showInputDialog("Digite o nome do segundo animal:"); // Solicita ao usuário que digite o nome do segundo animal
        String especie2 = JOptionPane.showInputDialog("Digite a espécie do segundo animal:"); // Solicita ao usuário que digite a espécie do segundo animal
        int idade2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do segundo animal:")); // Solicita ao usuário que digite a idade do segundo animal e converte para inteiro
        Animal animal2 = new Animal(nome2, especie2, idade2); // Cria um objeto da classe Animal com os dados fornecidos pelo usuário para o segundo animal
        JOptionPane.showMessageDialog(null, "Nome: " + animal2.getNome() + "\nEspécie: " + animal2.getEspecie() + "\nIdade: " + animal2.getIdade()); // Exibe as informações do segundo animal em uma caixa de diálogo
        if (idade1 > idade2) { // Compara as idades dos dois animais
            JOptionPane.showMessageDialog(null, animal1.getNome() + " é mais velho(a) que " + animal2.getNome()); // Exibe uma mensagem indicando que o primeiro animal é mais velho
        } else if (idade1 < idade2) { // Compara as idades dos dois animais
            JOptionPane.showMessageDialog(null, animal2.getNome() + " é mais velho(a) que " + animal1.getNome()); // Exibe uma mensagem indicando que o segundo animal é mais velho
        } else { // Caso as idades sejam iguais
            JOptionPane.showMessageDialog(null, animal1.getNome() + " e " + animal2.getNome() + " têm a mesma idade."); // Exibe uma mensagem indicando que os dois animais têm a mesma idade
        }
    }
}
