package Desafio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBidirectional {
    public static final String ADDRESS = "127.0.0.1";
    public static final int PORT = 3307;
    private volatile boolean executando = true;

    public void start() throws IOException {
        try (ServerSocket servidor = new ServerSocket(PORT)) {
            System.out.println("Servidor bidirecional em " + ADDRESS + ":" + PORT);
            while (executando) {
                Socket socket = servidor.accept();
                Thread worker = new Thread(() -> atender(socket), "cliente-" + socket.getPort());
                worker.start();
            }
        }
    }

    private void atender(Socket socket) {
        try (ClientSocketBidirectional cliente = new ClientSocketBidirectional(socket)) {
            String mensagem;
            while ((mensagem = cliente.getMessage()) != null) {
                System.out.printf("Recebida de %s: %s%n", cliente.getRemoteSocketAddress(), mensagem);
                String resposta = "Servidor recebeu: " + mensagem;
                if (!cliente.sendMsg(resposta)) {
                    System.err.println("Não foi possível responder a " + cliente.getRemoteSocketAddress());
                    break;
                }
                if (mensagem.equalsIgnoreCase("sair")) break;
            }
        } catch (IOException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            new ServerBidirectional().start();
        } catch (IOException e) {
            System.err.println("Não foi possível iniciar o servidor: " + e.getMessage());
        }
    }
}
