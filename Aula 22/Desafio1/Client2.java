package Desafio1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket(Server2.ADDRESS, Server2.PORT);
             Scanner teclado = new Scanner(System.in);
             PrintWriter saida = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println("Conectado ao Server2. Digite mensagens; 'sair' encerra.");
            while (true) {
                System.out.print("> ");
                if (!teclado.hasNextLine()) break;
                String mensagem = teclado.nextLine();
                saida.println(mensagem);
                if (mensagem.equalsIgnoreCase("sair")) break;
            }
        } catch (IOException e) {
            System.err.println("Erro no Client2: " + e.getMessage());
        }
        System.out.println("Client2 finalizado.");
    }
}
