package Desafio1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class Server2 {
    public static final String ADDRESS = "127.0.0.1";
    public static final int PORT = 3306;

    private final AtomicInteger clientesAtivos = new AtomicInteger();
    private volatile boolean recebeuCliente;
    private volatile boolean encerrando;
    private ServerSocket serverSocket;

    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor2 iniciado em " + ADDRESS + ":" + PORT);
        System.out.println("Aguardando clientes; o servidor termina após todos se desconectarem.");
        try {
            while (!encerrando) {
                Socket socket = serverSocket.accept();
                recebeuCliente = true;
                ClientSocket2 cliente = new ClientSocket2(socket);
                clientesAtivos.incrementAndGet();
                Thread worker = new Thread(() -> atender(cliente), "cliente-" + socket.getPort());
                worker.start();
            }
        } catch (IOException e) {
            if (!encerrando) throw e;
        } finally {
            if (!serverSocket.isClosed()) serverSocket.close();
            System.out.println("Servidor2 encerrado.");
        }
    }

    private void atender(ClientSocket2 cliente) {
        try (cliente) {
            String mensagem;
            while ((mensagem = cliente.getMessage()) != null
                    && !mensagem.equalsIgnoreCase("sair")) {
                System.out.printf("Mensagem de %s: %s%n", cliente.getRemoteSocketAddress(), mensagem);
            }
            System.out.println("Cliente " + cliente.getRemoteSocketAddress() + " desconectado.");
        } catch (IOException e) {
            System.err.println("Falha na conexão com " + cliente.getRemoteSocketAddress() + ": " + e.getMessage());
        } finally {
            if (clientesAtivos.decrementAndGet() == 0 && recebeuCliente) {
                encerrando = true;
                try {
                    serverSocket.close(); // desbloqueia accept() para finalizar o laço
                } catch (IOException e) {
                    System.err.println("Erro ao fechar o servidor: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Server2().start();
        } catch (IOException e) {
            System.err.println("Não foi possível iniciar o Server2: " + e.getMessage());
        }
    }
}
