import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Cliente TCP simples, compatível com o protocolo de eco do servidor. */
public class ClientTest implements AutoCloseable {
    private final String endereco;
    private final int porta;
    private Socket cliente;
    private Scanner entrada;
    private PrintWriter saida;

    public ClientTest(String endereco, int porta) {
        this.endereco = endereco;
        this.porta = porta;
    }

    public void conectar() throws IOException {
        cliente = new Socket(endereco, porta);
        entrada = new Scanner(cliente.getInputStream());
        saida = new PrintWriter(cliente.getOutputStream(), true);
    }

    public String enviar(String mensagem) throws IOException {
        if (saida == null || entrada == null) {
            throw new IllegalStateException("Cliente não conectado");
        }
        saida.println(mensagem);
        if (!entrada.hasNextLine()) {
            throw new IOException("Servidor fechou a conexão antes de responder");
        }
        return entrada.nextLine();
    }

    public List<String> enviarTodas(List<String> mensagens) throws IOException {
        List<String> respostas = new ArrayList<>();
        for (String mensagem : mensagens) {
            respostas.add(enviar(mensagem));
        }
        return respostas;
    }

    @Override
    public void close() throws IOException {
        if (saida != null) {
            saida.println("sair");
        }
        if (cliente != null) {
            cliente.close();
        }
    }

    public static void main(String[] args) {
        String endereco = args.length > 0 ? args[0] : ServerTest.ENDERECO;
        int porta = args.length > 1 ? Integer.parseInt(args[1]) : ServerTest.PORTA;
        List<String> mensagens = new ArrayList<>();
        for (int i = 2; i < args.length; i++) {
            mensagens.add(args[i]);
        }
        if (mensagens.isEmpty()) {
            mensagens.add("mensagem de teste");
        }

        try (ClientTest cliente = new ClientTest(endereco, porta)) {
            cliente.conectar();
            for (String mensagem : mensagens) {
                String eco = cliente.enviar(mensagem);
                System.out.printf("Enviou: %s | Ecoou: %s%n", mensagem, eco);
            }
        } catch (IOException ex) {
            System.err.println("Erro no Cliente: " + ex.getMessage());
        }
    }
}
