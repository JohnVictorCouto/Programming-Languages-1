import javax.swing.JOptionPane;

public class ex17 {
    public static void main(String[] args) {
    // Lê os anos digitados
    int birth = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento"));
    int today = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano atual"));
    int idade = today-birth;

    // Calcula a idade e verifica se os anos são válidos
    String resultado = (birth > today && today < 0 || birth < 0) ? "Invalido" : Integer.toString(idade);
    
    // Mostra o resultado
    JOptionPane.showMessageDialog(null, resultado);
    }
}