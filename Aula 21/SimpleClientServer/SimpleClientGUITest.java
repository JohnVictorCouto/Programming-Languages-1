import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SimpleClientGUITest extends JFrame {
    private static final String ENDERECO = "127.0.0.1";
    private static final int PORTA = 3305;

    private Socket cliente;
    private Scanner entrada;
    private PrintStream saida;

    // Componentes da Interface Gráfica
    private JTextArea areaEstado;
    private JTextField campoMensagem;
    private JButton btnEnviar;
    private JButton btnLimpar;
    private JButton btnSair;

    public SimpleClientGUITest() {
        configurarInterface();
        iniciarConexao();
    }

    private void configurarInterface() {
        setTitle("Cliente Java - Bidirecional (Interface Gráfica)");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área para exibir as mensagens de estado e respostas do servidor
        areaEstado = new JTextArea();
        areaEstado.setEditable(false);
        add(new JScrollPane(areaEstado), BorderLayout.CENTER);

        // Painel inferior para o campo de texto e botões
        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new BorderLayout());

        campoMensagem = new JTextField();
        painelInferior.add(campoMensagem, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());

        btnEnviar = new JButton("Enviar");
        btnLimpar = new JButton("Limpar");
        btnSair = new JButton("Sair");

        painelBotoes.add(btnEnviar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnSair);

        painelInferior.add(painelBotoes, BorderLayout.EAST);
        add(painelInferior, BorderLayout.SOUTH);

        // Ações dos botões
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensagem();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoMensagem.setText(""); // Limpa o campo de texto
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encerrarConexao();
            }
        });
    }

    private void iniciarConexao() {
        try {
            cliente = new Socket(ENDERECO, PORTA);
            entrada = new Scanner(cliente.getInputStream());
            saida = new PrintStream(cliente.getOutputStream());
            areaEstado.append(">>> Conectado ao Servidor (IP: " + ENDERECO + " | Porta: " + PORTA + ")\n\n");
        } catch (IOException ex) {
            areaEstado.append(">>> Erro ao conectar ao Servidor: " + ex.getMessage() + "\n");
        }
    }

    private void enviarMensagem() {
        String msg = campoMensagem.getText();
        if (msg != null && !msg.trim().isEmpty() && saida != null) {
            // Envia para o servidor
            saida.println(msg);
            areaEstado.append("Enviou: " + msg + "\n");

            // Aguarda e lê a resposta (Eco) do servidor
            if (entrada.hasNextLine()) {
                String eco = entrada.nextLine();
                areaEstado.append("Ecoou: " + eco + "\n\n");
            }
            campoMensagem.setText("");
        }
    }

    private void encerrarConexao() {
        try {
            if (saida != null) {
                saida.println("sair"); // Informa o servidor da saída
            }
            if (cliente != null) {
                cliente.close();
            }
        } catch (IOException ex) {
            System.out.println("Erro ao fechar conexão: " + ex.getMessage());
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        // Assegura que a interface gráfica é iniciada na Thread correta (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleClientGUITest().setVisible(true);
            }
        });
    }
}