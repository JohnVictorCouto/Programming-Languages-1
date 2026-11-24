import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Servidor de um cliente que devolve ao remetente cada mensagem recebida.
 */
public class SimpleServer2Test {
    public static final String ENDERECO = "127.0.0.1";
    public static final int PORTA = 3335;

    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(PORTA)) {
            System.out.println("Servidor de eco iniciado na porta " + PORTA);

            try (Socket cliente = servidor.accept();
                 BufferedReader entrada = new BufferedReader(new InputStreamReader(
                         cliente.getInputStream(), StandardCharsets.UTF_8));
                 PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true,
                         StandardCharsets.UTF_8)) {

                System.out.println("Cliente do IP: "
                        + cliente.getInetAddress().getHostAddress() + " conectado ao servidor");
                System.out.println("Mensagens do Cliente:");

                String mensagem;
                while ((mensagem = entrada.readLine()) != null) {
                    System.out.println(mensagem);
                    saida.println(mensagem);
                    if (saida.checkError()) {
                        System.out.println("Falha ao retransmitir a mensagem ao cliente.");
                        break;
                    }
                }
            }

            System.out.println("Servidor finalizado!");
        } catch (IOException ex) {
            System.out.println("Erro ao criar ou executar o servidor!");
            ex.printStackTrace();
        }
    }
}
