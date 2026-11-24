import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class SimpleServerTest {
    // Especifica endereco do IP local para o servidor
    public static final String ENDERECO = "127.0.0.1";
    // Especifica porta livre do computador para o servidor escutar
    public static final int PORTA = 3335;

    public static void main(String args[]) {
        try {
            // Cria servico de escuta da porta especificada via socket no servidor
            ServerSocket servidor = new ServerSocket(PORTA);
            System.out.println("Servidor iniciado na porta " + PORTA);

            // Cria canal de comunicacao para a conexao de um cliente (bloqueia o codigo ate alguem conectar)
            Socket cliente = servidor.accept();

            // Apresenta endereco do cliente conectado ao servidor
            System.out.println("Cliente do IP: " + cliente.getInetAddress().getHostAddress() + " conectado ao servidor");

            // Obtem a entrada do canal (socket)
            Scanner entrada = new Scanner(cliente.getInputStream());

            // Escutando as mensagens do cliente que chegam ao servidor
            System.out.println("Mensagens do Cliente:");
            while (entrada.hasNextLine()) { // Enquanto a entrada tiver uma proxima linha
                System.out.println(entrada.nextLine()); // Imprime na tela a mensagem
            }

            // Fechando o canal de entrada do servidor e o servico de conexao ao servidor
            System.out.println("Servidor finalizado!");
            entrada.close(); // Fecha o canal de comunicacao (tambem fecha o cliente)
            servidor.close(); // Fecha o servico do servidor
        } catch (IOException ex) {
            System.out.println("Erro ao criar o servidor!");
            ex.printStackTrace();
        }
    }
}
