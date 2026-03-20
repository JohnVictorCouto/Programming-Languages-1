import java.util.Scanner;

public class ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário

        System.out.print("Digite o limite inferior (Celsius): "); // Solicita ao usuário que digite o limite inferior da tabela de conversão em Celsius
        double inferior = scanner.nextDouble(); // Lê o limite inferior da tabela de conversão em Celsius como um número de ponto flutuante

        System.out.print("Digite o limite superior (Celsius): "); // Solicita ao usuário que digite o limite superior da tabela de conversão em Celsius
        double superior = scanner.nextDouble(); // Lê o limite superior da tabela de conversão em Celsius como um número de ponto flutuante

        System.out.print("Digite o incremento: "); // Solicita ao usuário que digite o incremento entre os valores de Celsius na tabela de conversão
        double incremento = scanner.nextDouble(); // Lê o incremento entre os valores de Celsius na tabela de conversão como um número de ponto flutuante

        System.out.printf("%-10s | %-10s\n", "Celsius", "Fahrenheit");

        // Loop para gerar a tabela de conversão de Celsius para Fahrenheit, começando do limite inferior, incrementando pelo valor do incremento, e terminando no limite superior
        for (double c = inferior; c <= superior; c += incremento) {
            double f = (c * 9.0 / 5.0) + 32.0;
            System.out.printf("%-10.2f | %-10.2f\n", c, f);
        }
        scanner.close();
    }
}
