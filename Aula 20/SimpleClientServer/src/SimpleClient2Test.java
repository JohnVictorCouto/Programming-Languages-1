import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Cliente com interface grafica para o servidor de eco SimpleServer2Test. */
public class SimpleClient2Test extends JFrame {
    private final JTextField campoEndereco = new JTextField(SimpleServer2Test.ENDERECO, 15);
    private final JTextField campoPorta = new JTextField(String.valueOf(SimpleServer2Test.PORTA), 5);
    private final JTextField campoMensagem = new JTextField(32);
    private final JTextArea areaStatus = new JTextArea(12, 42);
    private final JButton botaoConectar = new JButton("Conectar");
    private final JButton botaoEnviar = new JButton("Enviar");
    private Socket cliente;
    private PrintWriter saida;
    private volatile boolean encerrado;

    public SimpleClient2Test() {
        super("Cliente com eco do servidor");
        montarInterface();
    }

    private void montarInterface() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        JPanel painelConexao = new JPanel(new GridLayout(1, 5, 6, 0));
        painelConexao.setBorder(BorderFactory.createTitledBorder("Conexao com o servidor"));
        painelConexao.add(new JLabel("IP/Host:"));
        painelConexao.add(campoEndereco);
        painelConexao.add(new JLabel("Porta:"));
        painelConexao.add(campoPorta);
        painelConexao.add(botaoConectar);

        JPanel painelMensagem = new JPanel(new BorderLayout(6, 6));
        painelMensagem.setBorder(BorderFactory.createTitledBorder("Mensagem para o servidor"));
        painelMensagem.add(new JLabel("Mensagem:"), BorderLayout.WEST);
        painelMensagem.add(campoMensagem, BorderLayout.CENTER);

        JPanel painelSuperior = new JPanel(new BorderLayout(0, 6));
        painelSuperior.add(painelConexao, BorderLayout.NORTH);
        painelSuperior.add(painelMensagem, BorderLayout.SOUTH);
        add(painelSuperior, BorderLayout.NORTH);

        areaStatus.setEditable(false);
        areaStatus.setLineWrap(true);
        areaStatus.setWrapStyleWord(true);
        JScrollPane rolagem = new JScrollPane(areaStatus);
        rolagem.setBorder(BorderFactory.createTitledBorder("Historico da comunicacao"));
        add(rolagem, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botaoLimpar = new JButton("Limpar");
        JButton botaoSair = new JButton("Sair");
        painelBotoes.add(botaoEnviar);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoSair);
        add(painelBotoes, BorderLayout.SOUTH);

        botaoEnviar.setEnabled(false);
        botaoConectar.addActionListener(e -> conectarAoServidor());
        botaoEnviar.addActionListener(e -> enviarMensagem());
        campoMensagem.addActionListener(e -> enviarMensagem());
        botaoLimpar.addActionListener(e -> campoMensagem.setText(""));
        botaoSair.addActionListener(e -> encerrarCliente());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                encerrarCliente();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void conectarAoServidor() {
        String endereco = campoEndereco.getText().trim();
        int porta;
        try {
            porta = Integer.parseInt(campoPorta.getText().trim());
            if (endereco.isEmpty() || porta < 1 || porta > 65535) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            registrarStatus("Informe um IP/Host e uma porta entre 1 e 65535.");
            return;
        }

        botaoConectar.setEnabled(false);
        campoEndereco.setEditable(false);
        campoPorta.setEditable(false);
        registrarStatus("Conectando a " + endereco + ":" + porta + "...");
        new Thread(() -> abrirConexao(endereco, porta), "conexao-cliente").start();
    }

    private void abrirConexao(String endereco, int porta) {
        try {
            Socket novoCliente = new Socket(endereco, porta);
            PrintWriter novaSaida = new PrintWriter(novoCliente.getOutputStream(), true,
                    StandardCharsets.UTF_8);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(
                    novoCliente.getInputStream(), StandardCharsets.UTF_8));
            if (encerrado) {
                novoCliente.close();
                return;
            }

            cliente = novoCliente;
            saida = novaSaida;
            SwingUtilities.invokeLater(() -> {
                registrarStatus("Conectado ao servidor.");
                botaoEnviar.setEnabled(true);
                campoMensagem.requestFocusInWindow();
            });
            receberMensagens(entrada);
        } catch (IOException ex) {
            if (!encerrado) {
                SwingUtilities.invokeLater(() -> falhaNaConexao(ex.getMessage()));
            }
        }
    }

    private void receberMensagens(BufferedReader entrada) throws IOException {
        String mensagem;
        while ((mensagem = entrada.readLine()) != null) {
            String eco = mensagem;
            SwingUtilities.invokeLater(() -> registrarStatus("Servidor respondeu: " + eco));
        }
        if (!encerrado) {
            SwingUtilities.invokeLater(() -> {
                registrarStatus("Servidor encerrou a conexao.");
                botaoEnviar.setEnabled(false);
            });
        }
    }

    private void falhaNaConexao(String detalhe) {
        registrarStatus("Falha na comunicacao: " + detalhe);
        botaoConectar.setEnabled(true);
        campoEndereco.setEditable(true);
        campoPorta.setEditable(true);
    }

    private void enviarMensagem() {
        String mensagem = campoMensagem.getText().trim();
        if (mensagem.isEmpty()) {
            registrarStatus("Digite uma mensagem antes de enviar.");
            return;
        }
        if (saida == null) {
            registrarStatus("Nao ha conexao com o servidor.");
            return;
        }

        saida.println(mensagem);
        if (saida.checkError()) {
            registrarStatus("Falha ao enviar a mensagem.");
            botaoEnviar.setEnabled(false);
        } else {
            registrarStatus("Mensagem enviada: " + mensagem);
            campoMensagem.setText("");
        }
    }

    private void registrarStatus(String mensagem) {
        areaStatus.append(mensagem + System.lineSeparator());
        areaStatus.setCaretPosition(areaStatus.getDocument().getLength());
    }

    private void encerrarCliente() {
        if (encerrado) {
            return;
        }
        encerrado = true;
        botaoEnviar.setEnabled(false);
        try {
            if (saida != null) {
                saida.close();
            }
            if (cliente != null && !cliente.isClosed()) {
                cliente.close();
            }
            registrarStatus("Cliente desconectado do servidor.");
        } catch (IOException ex) {
            registrarStatus("Erro ao encerrar a conexao: " + ex.getMessage());
        } finally {
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleClient2Test::new);
    }
}
