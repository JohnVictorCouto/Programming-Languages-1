import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/** Teste executável: falha com AssertionError se qualquer eco for perdido ou cruzado. */
public class MultiClientIntegrationTest {
    private static final int CLIENTES = 12;
    private static final int MENSAGENS_POR_CLIENTE = 20;

    public static void main(String[] args) throws Exception {
        ServerTest servidor = new ServerTest(0);
        servidor.iniciar();
        ExecutorService pool = Executors.newFixedThreadPool(CLIENTES);
        CountDownLatch largada = new CountDownLatch(1);
        List<Future<Void>> tarefas = new ArrayList<>();

        try {
            for (int clienteId = 0; clienteId < CLIENTES; clienteId++) {
                final int id = clienteId;
                tarefas.add(pool.submit(() -> {
                    largada.await();
                    try (ClientTest cliente =
                                 new ClientTest(ServerTest.ENDERECO, servidor.getPorta())) {
                        cliente.conectar();
                        for (int n = 0; n < MENSAGENS_POR_CLIENTE; n++) {
                            String mensagem = "cliente-" + id + " mensagem-" + n;
                            String resposta = cliente.enviar(mensagem);
                            if (!mensagem.equals(resposta)) {
                                throw new AssertionError("Eco incorreto: esperado='" + mensagem
                                        + "', recebido='" + resposta + "'");
                            }
                        }
                    }
                    return null;
                }));
            }
            largada.countDown();
            for (Future<Void> tarefa : tarefas) {
                tarefa.get(30, TimeUnit.SECONDS);
            }
            System.out.printf("OK: %d clientes x %d mensagens = %d ecos validados.%n",
                    CLIENTES, MENSAGENS_POR_CLIENTE, CLIENTES * MENSAGENS_POR_CLIENTE);
        } finally {
            pool.shutdownNow();
            servidor.parar();
        }
    }
}
