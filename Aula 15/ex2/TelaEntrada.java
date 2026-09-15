import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class TelaEntrada extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JLabel lblUsuario, lblSenha;
    private JButton btnEntrar, btnSair;
    private LoginDAO loginDAO;
    
    private static ResourceBundle bundle = ResourceBundle.getBundle("mensagens", new Locale("pt", "BR"));

    public TelaEntrada() {
        loginDAO = new LoginDAO();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        getContentPane().removeAll();
        setTitle(bundle.getString("app.titulo.login"));
        setSize(350, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Criar Menu de Idioma antes do login
        JMenuBar menuBar = new JMenuBar();
        JMenu menuIdioma = new JMenu(bundle.getString("menu.idioma"));
        JMenuItem itemPt = new JMenuItem(bundle.getString("menu.idioma.pt"));
        JMenuItem itemEn = new JMenuItem(bundle.getString("menu.idioma.en"));
        JMenuItem itemFr = new JMenuItem(bundle.getString("menu.idioma.fr"));
        JMenuItem itemJa = new JMenuItem(bundle.getString("menu.idioma.ja"));


        itemPt.addActionListener(e -> trocarIdioma(new Locale("pt", "BR")));
        itemEn.addActionListener(e -> trocarIdioma(Locale.US));
        itemFr.addActionListener(e -> trocarIdioma(Locale.FRANCE));
        itemJa.addActionListener(e -> trocarIdioma(Locale.JAPAN)); // Adicionando suporte ao idioma japonês

        menuIdioma.add(itemPt);
        menuIdioma.add(itemEn);
        menuIdioma.add(itemFr);
        menuIdioma.add(itemJa);
        menuBar.add(menuIdioma);
        setJMenuBar(menuBar);

        lblUsuario = new JLabel(bundle.getString("login.usuario"));
        lblUsuario.setBounds(35, 20, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(110, 20, 180, 25);
        add(txtUsuario);

        lblSenha = new JLabel(bundle.getString("login.senha"));
        lblSenha.setBounds(35, 60, 80, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(110, 60, 180, 25);
        add(txtSenha);

        btnEntrar = new JButton(bundle.getString("login.entrar"));
        btnEntrar.setBounds(110, 105, 100, 30);
        add(btnEntrar);

        btnSair = new JButton(bundle.getString("login.sair"));
        btnSair.setBounds(220, 105, 70, 30);
        add(btnSair);

        ActionListener entrar = e -> autenticar();

        btnEntrar.addActionListener(entrar);
        txtSenha.addActionListener(entrar);
        btnSair.addActionListener(e -> System.exit(0));

        revalidate();
        repaint();
    }

    private void trocarIdioma(Locale locale) {
        bundle = ResourceBundle.getBundle("mensagens", locale);
        inicializarComponentes();
    }

    public static ResourceBundle getBundle() {
        return bundle;
    }

    private void autenticar() {
        String usuario = txtUsuario.getText().trim();
        String senha = new String(txtSenha.getPassword());

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, bundle.getString("login.erro.vazio"));
            return;
        }

        int loginId = loginDAO.validarLogin(usuario, senha);

        if (loginId != -1) {
            JOptionPane.showMessageDialog(this, bundle.getString("login.sucesso"));
            dispose();
            new TelaMEDIA(loginId, usuario);
        } else {
            JOptionPane.showMessageDialog(this, bundle.getString("login.erro.incorreto"));
            txtSenha.setText("");
            txtSenha.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaEntrada().setVisible(true));
    }
}