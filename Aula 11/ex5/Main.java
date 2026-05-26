import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField tela;
    private long resultado = 0;
    private String operadorPendente = "=";
    private boolean novoNumero = true;

    public Main() {
        // Configurações da Janela
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tela de exibição
        tela = new JTextField("0");
        tela.setEditable(false);
        tela.setHorizontalAlignment(JTextField.RIGHT);
        tela.setFont(new Font("Arial", Font.BOLD, 24));
        add(tela, BorderLayout.NORTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 4, 5, 5));

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.addActionListener(this);
            botao.setFont(new Font("Arial", Font.BOLD, 18));
            painelBotoes.add(botao);
        }

        add(painelBotoes, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.charAt(0) >= '0' && comando.charAt(0) <= '9') {
            // Se for número
            if (novoNumero) {
                tela.setText(comando);
                novoNumero = false;
            } else {
                tela.setText(tela.getText() + comando);
            }
        } else if (comando.equals("C")) {
            // Limpar tudo
            resultado = 0;
            operadorPendente = "=";
            novoNumero = true;
            tela.setText("0");
        } else {
            // Se for operador (+, -, *, /, =)
            calcular(Integer.parseInt(tela.getText()));
            operadorPendente = comando;
            novoNumero = true;
        }
    }

    private void calcular(int n) {
        switch (operadorPendente) {
            case "+": resultado += n; break;
            case "-": resultado -= n; break;
            case "*": resultado *= n; break;
            case "/": 
                if (n != 0) resultado /= n; 
                else JOptionPane.showMessageDialog(this, "Erro: Divisão por zero");
                break;
            case "=": resultado = n; break;
        }
        tela.setText(String.valueOf(resultado));
    }

    public static void main(String[] args) {
        new Main();
    }
}