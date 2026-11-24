package Desafio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

public final class ClientSocketBidirectional implements AutoCloseable {
    private final Socket socket;
    private final BufferedReader entrada;
    private final PrintWriter saida;

    public ClientSocketBidirectional(Socket socket) throws IOException {
        this.socket = socket;
        this.entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.saida = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Cliente " + getRemoteSocketAddress() + " conectado.");
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public String getMessage() throws IOException {
        return entrada.readLine();
    }

    public boolean sendMsg(String mensagem) {
        saida.println(mensagem);
        return !saida.checkError();
    }

    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Erro ao fechar cliente: " + e.getMessage());
        }
    }
}
