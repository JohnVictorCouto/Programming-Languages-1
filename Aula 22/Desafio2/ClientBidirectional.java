package Desafio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientBidirectional {
    public static void main(String[] args) {
        try (Socket socket = new Socket(ServerBidirectional.ADDRESS, ServerBidirectional.PORT);
             Scanner teclado = new Scanner(System.in);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter saida = new PrintWriter(socket.getOutputStream(), true)) {
            Thread leitor = new Thread(() -> {
                try {
                    String resposta;
                    while ((resposta = entrada.readLine()) != null) {
                        System.out.println("[resposta] " + resposta);
                        if (resposta.endsWith(": sair")) break;
                    }
                } catch (IOException e) {
                    if (!socket.isClosed()) System.err.println("Erro ao receber resposta: " + e.getMessage());
                }
            }, "leitor-do-servidor");
            leitor.start();

            System.out.println("Conectado. Digite mensagens; 'sair' encerra.");
            while (true) {
                System.out.print("> ");
                if (!teclado.hasNextLine()) {
                    saida.println("sair");
                    break;
                }
                String mensagem = teclado.nextLine();
                saida.println(mensagem);
                if (mensagem.equalsIgnoreCase("sair")) break;
            }
            leitor.join(2000);
        } catch (IOException e) {
            System.err.println("Erro no ClientBidirectional: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Aguardando resposta foi interrompido.");
        }
    }
}
