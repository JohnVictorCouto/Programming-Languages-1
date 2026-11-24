package ProjetoBatepapo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

final class BatepapoJanela
{
  private final JFrame frame;
  private final JTextArea conversationArea = new JTextArea();
  private final JTextArea statusArea = new JTextArea(4, 20);
  private final JTextField messageField = new JTextField();
  private final JButton sendButton = new JButton("Enviar");
  private final JButton clearButton = new JButton("Limpar");
  private final JButton exitButton = new JButton("Sair");
  private final ExecutorService sender = Executors.newSingleThreadExecutor();
  private volatile SocketCliente clientSocket;
  private volatile boolean closing;

  BatepapoJanela(String title)
  {
    frame = new JFrame(title);
    buildInterface();
    setConnectedControls(false);
    frame.setVisible(true);
    connectToServer();
  }

  private void buildInterface()
  {
    conversationArea.setEditable(false);
    conversationArea.setLineWrap(true);
    conversationArea.setWrapStyleWord(true);
    statusArea.setEditable(false);
    statusArea.setLineWrap(true);
    statusArea.setWrapStyleWord(true);

    JPanel conversationPanel = new JPanel(new BorderLayout(5, 5));
    conversationPanel.setBorder(BorderFactory.createTitledBorder("Mensagens"));
    conversationPanel.add(new JScrollPane(conversationArea), BorderLayout.CENTER);

    JPanel statusPanel = new JPanel(new BorderLayout(5, 5));
    statusPanel.setBorder(BorderFactory.createTitledBorder("Status da comunicação"));
    statusPanel.add(new JScrollPane(statusArea), BorderLayout.CENTER);

    JPanel messagePanel = new JPanel(new BorderLayout(5, 5));
    messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    messagePanel.add(new JLabel("Mensagem:"), BorderLayout.WEST);
    messagePanel.add(messageField, BorderLayout.CENTER);

    JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    buttons.add(sendButton);
    buttons.add(clearButton);
    buttons.add(exitButton);
    messagePanel.add(buttons, BorderLayout.SOUTH);

    JPanel center = new JPanel(new BorderLayout(5, 5));
    center.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
    center.add(conversationPanel, BorderLayout.CENTER);
    center.add(statusPanel, BorderLayout.SOUTH);

    frame.setLayout(new BorderLayout());
    frame.add(center, BorderLayout.CENTER);
    frame.add(messagePanel, BorderLayout.SOUTH);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.addWindowListener(new WindowAdapter()
    {
      @Override
      public void windowClosing(WindowEvent event)
      {
        exit();
      }
    });

    sendButton.addActionListener(event -> sendMessage());
    messageField.addActionListener(event -> sendMessage());
    clearButton.addActionListener(event ->
    {
      messageField.setText("");
      conversationArea.setText("");
    });
    exitButton.addActionListener(event -> exit());

    frame.setMinimumSize(new Dimension(480, 400));
    frame.setSize(560, 500);
    frame.setLocationByPlatform(true);
  }

  private void connectToServer()
  {
    appendStatus("Conectando a " + ServidorBatepapo.ADDRESS + ":"
        + ServidorBatepapo.PORT + "...");
    Thread connector = new Thread(() ->
    {
      try
      {
        SocketCliente connection = new SocketCliente(
            new Socket(ServidorBatepapo.ADDRESS, ServidorBatepapo.PORT));
        clientSocket = connection;
        if (closing)
        {
          connection.close();
          return;
        }
        appendStatus("Conectado ao servidor em "
            + connection.getRemoteSocketAddress() + ".");
        SwingUtilities.invokeLater(() -> setConnectedControls(true));
        receiveMessages(connection);
      }
      catch (IOException ex)
      {
        if (!closing)
        {
          appendStatus("Falha na conexão: " + ex.getMessage());
          SwingUtilities.invokeLater(() -> setConnectedControls(false));
        }
      }
    }, "cliente-batepapo-conexao");
    connector.setDaemon(true);
    connector.start();
  }

  private void receiveMessages(SocketCliente connection)
  {
    String message;
    while (!closing && (message = connection.getMessage()) != null)
    {
      appendMessage(message);
    }
    if (!closing)
    {
      appendStatus("O servidor encerrou a conexão.");
      SwingUtilities.invokeLater(() -> setConnectedControls(false));
    }
  }

  private void sendMessage()
  {
    SocketCliente connection = clientSocket;
    String message = messageField.getText().trim();
    if (connection == null || message.isEmpty() || closing)
    {
      return;
    }

    messageField.setText("");
    if ("sair".equalsIgnoreCase(message))
    {
      exit();
      return;
    }

    appendMessage("Você: " + message);
    sender.execute(() ->
    {
      if (!connection.sendMsg(message))
      {
        appendStatus("Não foi possível enviar a mensagem.");
        SwingUtilities.invokeLater(() -> setConnectedControls(false));
      }
    });
  }

  private void exit()
  {
    if (closing)
    {
      return;
    }
    closing = true;
    setConnectedControls(false);
    appendStatus("Encerrando a conexão...");
    sender.execute(() ->
    {
      SocketCliente connection = clientSocket;
      if (connection != null)
      {
        connection.sendMsg("sair");
        connection.close();
      }
      sender.shutdown();
      SwingUtilities.invokeLater(frame::dispose);
    });
  }

  private void setConnectedControls(boolean connected)
  {
    sendButton.setEnabled(connected);
    messageField.setEnabled(connected);
    clearButton.setEnabled(true);
  }

  private void appendMessage(String message)
  {
    SwingUtilities.invokeLater(() ->
    {
      conversationArea.append(message + System.lineSeparator());
      conversationArea.setCaretPosition(conversationArea.getDocument().getLength());
    });
  }

  private void appendStatus(String status)
  {
    SwingUtilities.invokeLater(() ->
    {
      statusArea.append(status + System.lineSeparator());
      statusArea.setCaretPosition(statusArea.getDocument().getLength());
    });
  }
}
