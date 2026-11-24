import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer2Test {
    public static final int PORTA = 3305;

    private static ServerSocket servidor;
    private static Socket clienteAceito;
    private static Scanner entradaCliente;
    private static PrintStream saidaCliente;
    private static Scanner tecladoServidor; // Novo Scanner para ler da consola do servidor

    public static void main(String args[]) {
        System.out.println("*v*v* CONSOLE DO SERVIDOR INTERATIVO *v*v*");
        try {
            iniciaServidor();
            aguardaConexaoCliente();
            conversaComCliente();
            encerraConexaoCliente();
            encerraServidor();
        } catch (IOException ex) {
            System.out.println("Erro no Servidor: " + ex.getMessage());
        }
    }

    private static void iniciaServidor() throws IOException {
        servidor = new ServerSocket(PORTA);
        System.out.println("Servidor iniciado e a escutar a porta " + PORTA);
    }

    private static void aguardaConexaoCliente() throws IOException {
        clienteAceito = servidor.accept();
        System.out.println("Cliente IP " + clienteAceito.getInetAddress().getHostAddress() + " conectado!");
        
        entradaCliente = new Scanner(clienteAceito.getInputStream());
        saidaCliente = new PrintStream(clienteAceito.getOutputStream());
        tecladoServidor = new Scanner(System.in); // Prepara a leitura do teclado do Servidor
    }

    private static void conversaComCliente() throws IOException {
        String msgCliente;
        
        // Escutando as mensagens do cliente
        while (entradaCliente.hasNextLine()) {
            msgCliente = entradaCliente.nextLine();
            
            if(msgCliente.equalsIgnoreCase("sair")) {
                break; // Sai do ciclo se o cliente pediu para terminar
            }

            System.out.println("\n-------------------------------------------------");
            System.out.println("Chegou do Cliente: " + msgCliente);
            
            // Permite ao servidor editar ou confirmar a mensagem
            System.out.print("Edite a mensagem para reenvio (ou prima ENTER para manter a mesma): ");
            String edicaoServidor = tecladoServidor.nextLine();
            
            String msgRetorno;
            if (edicaoServidor.trim().isEmpty()) {
                msgRetorno = msgCliente; // Se não digitou nada, mantém a original
            } else {
                msgRetorno = edicaoServidor; // Substitui pela versão editada
            }

            // Retorna a mensagem definida para o cliente
            saidaCliente.println(msgRetorno);
            System.out.println("Enviado ao Cliente: " + msgRetorno);
        }
    }

    private static void encerraConexaoCliente() throws IOException {
        entradaCliente.close();
        System.out.println("\nCliente desconectou-se do Servidor!");
    }

    private static void encerraServidor() throws IOException {
        servidor.close();
        if(tecladoServidor != null) tecladoServidor.close();
        System.out.println("Servidor finalizado!");
    }
}