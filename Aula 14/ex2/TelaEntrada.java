import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEntrada extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private LoginDAO loginDAO;

    public TelaEntrada() {
        loginDAO = new LoginDAO();

        setTitle("IMT - Login");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(35, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(110, 30, 180, 25);
        add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(35, 70, 80, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(110, 70, 180, 25);
        add(txtSenha);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(110, 115, 100, 30);
        add(btnEntrar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(220, 115, 70, 30);
        add(btnSair);

        ActionListener entrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticar();
            }
        };

        btnEntrar.addActionListener(entrar);
        txtSenha.addActionListener(entrar);

        btnSair.addActionListener(e -> System.exit(0));
    }

    private void autenticar() {
        String usuario = txtUsuario.getText().trim();
        String senha = new String(txtSenha.getPassword());

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Informe usuário e senha.");
            return;
        }

        int loginId = loginDAO.validarLogin(usuario, senha);

        if (loginId != -1) {
            JOptionPane.showMessageDialog(this,
                    "Login efetuado com sucesso!");

            dispose();
            new TelaMEDIA(loginId, usuario);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuário ou senha incorretos.");
            txtSenha.setText("");
            txtSenha.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaEntrada().setVisible(true));
    }
}