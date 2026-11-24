import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;
public class Client {
    private Socket clientSocket;
    private PrintWriter saida;
    private Scanner scanner;
    public Client() {
        scanner = new Scanner(System.in);
    }
    public void start() throws IOException {
        clientSocket = new Socket(Server.ADDRESS, Server.PORT);
        saida = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("Conectado ao servidor " + Server.ADDRESS + ":" + Server.PORT);
        messageLoop();
    }
    private void messageLoop() throws IOException {
        String msg;
        System.out.println("Aguardando mensagens do servidor");
        do{
            System.out.print("Digite uma mensagem (ou 'sair' para encerrar): ");
            msg = scanner.nextLine();
            saida.println(msg);
        } while (!msg.equalsIgnoreCase("sair"));
    }
    public static void main(String[] args) {
        System.out.println("Iniciando cliente...");
        try{
            Client client = new Client();
            client.start();
        } catch (IOException ex) {
            System.err.println("Erro ao iniciar o cliente: " + ex.getMessage());
        }
        System.out.println("Cliente finalizado.");
    }
}
