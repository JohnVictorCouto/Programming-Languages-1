import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // cria um objeto Scanner para ler a entrada do usuário
        Relogio relogio = new Relogio(); // cria um objeto Relogio, que representa um relógio digital

        System.out.println("Digite 'tictac' para avançar o relógio.");
        System.out.println("Digite 'sair' para encerrar.");

        while (true) {
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("tictac")) { // se o usuário digitar "tictac", avança o relógio em um minuto
                relogio.ticTac(); // chama o método ticTac() do objeto Relogio para avançar o relógio
                System.out.println(relogio.mostra()); // exibe a hora atual do relógio usando o método mostra() do objeto Relogio
            } 
            else if (entrada.equalsIgnoreCase("sair")) { // se o usuário digitar "sair", encerra o programa
                break; // sai do loop e encerra o programa
            } 
            else { // se o usuário digitar qualquer outra coisa, exibe uma mensagem de comando inválido
                System.out.println("Comando inválido.");
            }
        }

        scanner.close();
    }
}