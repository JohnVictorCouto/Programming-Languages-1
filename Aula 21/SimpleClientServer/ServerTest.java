import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Servidor TCP de eco concorrente: cada cliente é atendido por uma tarefa
 * independente, permitindo comunicações simultâneas.
 */
public class ServerTest implements AutoCloseable {
    public static final String ENDERECO = "127.0.0.1";
    public static final int PORTA = 3305;

    private final int portaSolicitada;
    private final ExecutorService clientes = Executors.newCachedThreadPool();
    private volatile boolean executando;
    private ServerSocket servidor;
    private Thread threadAceitacao;

    public ServerTest() {
        this(PORTA);
    }

    public ServerTest(int porta) {
        if (porta < 0 || porta > 65535) {
            throw new IllegalArgumentException("Porta inválida: " + porta);
        }
        this.portaSolicitada = porta;
    }

    /** Inicia o socket e a thread que aceita conexões. Porta 0 escolhe uma porta livre. */
    public synchronized void iniciar() throws IOException {
        if (executando) {
            throw new IllegalStateException("Servidor já está em execução");
        }
        servidor = new ServerSocket(portaSolicitada);
        executando = true;
        threadAceitacao = new Thread(this::aceitarClientes, "servidor-aceitacao");
        threadAceitacao.setDaemon(true);
        threadAceitacao.start();
        System.out.println("Servidor iniciado e escutando a porta " + getPorta());
    }

    private void aceitarClientes() {
        while (executando) {
            try {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getRemoteSocketAddress());
                clientes.submit(() -> atenderCliente(cliente));
            } catch (IOException ex) {
                if (executando) {
                    System.err.println("Erro ao aceitar cliente: " + ex.getMessage());
                }
            }
        }
    }

    private void atenderCliente(Socket cliente) {
        try (Socket socket = cliente;
             Scanner entrada = new Scanner(socket.getInputStream());
             PrintWriter saida = new PrintWriter(socket.getOutputStream(), true)) {
            while (entrada.hasNextLine()) {
                String mensagem = entrada.nextLine();
                System.out.printf("[%s] Chegou do Cliente: %s%n",
                        socket.getRemoteSocketAddress(), mensagem);
                if (mensagem.equalsIgnoreCase("sair")) {
                    break;
                }
                saida.println(mensagem);
                System.out.printf("[%s] Ecoou ao Cliente: %s%n",
                        socket.getRemoteSocketAddress(), mensagem);
            }
        } catch (IOException ex) {
            if (executando) {
                System.err.println("Conexão encerrada com erro: " + ex.getMessage());
            }
        } finally {
            System.out.println("Cliente desconectado");
        }
    }

    public synchronized void parar() throws IOException {
        if (!executando) {
            return;
        }
        executando = false;
        servidor.close();
        clientes.shutdownNow();
        System.out.println("Servidor finalizado");
    }

    public int getPorta() {
        if (servidor == null) {
            return portaSolicitada;
        }
        return servidor.getLocalPort();
    }

    public boolean isExecutando() {
        return executando;
    }

    @Override
    public void close() throws IOException {
        parar();
    }

    public static void main(String[] args) {
        ServerTest servidor = new ServerTest();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                servidor.parar();
            } catch (IOException ignored) {
                // O processo já está sendo encerrado.
            }
        }));
        try {
            servidor.iniciar();
            Thread.currentThread().join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } catch (IOException ex) {
            System.err.println("Erro no Servidor: " + ex.getMessage());
        }
    }
}
