import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário
        
        int num; // Variável para armazenar o número digitado pelo usuário

        System.out.println("Digite números (-999 para parar):"); 

        // Loop até o usuário digitar -999
        while (true) {
            num = scan.nextInt(); // Lê o número digitado pelo usuário

            if (num == -999) {
                break; // encerra o programa
            }

            System.out.println("Divisores de " + num + ":");

            // Calcula e imprime os divisores
            for (int i = 1; i <= Math.abs(num); i++) {
                if (num % i == 0) { // Verifica se i é um divisor de num
                    System.out.print(i + " ");
                }
            }

            System.out.println("\n"); // quebra de linha
        }

        scan.close(); // Fecha o Scanner para liberar recursos
    }
}