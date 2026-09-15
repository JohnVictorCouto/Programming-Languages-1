import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaExemplo extends JFrame implements ActionListener { 
    private JButton bt;
    private JTextField tx;
    private JLabel rt;
    private ResourceBundle bn;
    
    // Componentes do Menu de Idiomas
    private JMenuBar menuBar;
    private JMenu menuIdioma;
    private JMenuItem itemPt;
    private JMenuItem itemEn;
    private JMenuItem itemFr;
    private JMenuItem itemIt;

    public TelaExemplo() {
        // Inicializa com o idioma padrão
        carregarIdioma(new Locale("pt", "BR"));
    }

    private void carregarIdioma(Locale locale) {
        try {
            bn = ResourceBundle.getBundle("Ex1", locale);
        } catch (Exception e) {
            bn = ResourceBundle.getBundle("Ex1"); // Fallback
        }

        Container cx = getContentPane();
        cx.setLayout(new FlowLayout());
        cx.removeAll(); // Remove componentes anteriores para redesenhar com o novo idioma

        // Inicializa componentes com os textos traduzidos
        bt = new JButton(bn.getString("tela1.botao.calcular"));
        rt = new JLabel(bn.getString("tela1.rotulo.valor") + ":");
        if (tx == null) {
            tx = new JTextField(10);
        }

        cx.add(rt);
        cx.add(tx);
        cx.add(bt);
        bt.addActionListener(this);

        setTitle(bn.getString("tela1.titulo"));
        setSize(320, 130);
        setLocationRelativeTo(null);

        criarMenu();
    }

    private void criarMenu() {
        menuBar = new JMenuBar();
        menuIdioma = new JMenu(bn.getString("menu.idioma"));

        itemPt = new JMenuItem("Português");
        itemEn = new JMenuItem("English");
        itemFr = new JMenuItem("Français");
        itemIt = new JMenuItem("Italiano");

        // Ações para trocar o idioma dinamicamente pelo menu
        itemPt.addActionListener(e -> trocarIdioma(new Locale("pt", "BR")));
        itemEn.addActionListener(e -> trocarIdioma(Locale.US));
        itemFr.addActionListener(e -> trocarIdioma(Locale.FRANCE));
        itemIt.addActionListener(e -> trocarIdioma(Locale.ITALY));

        menuIdioma.add(itemPt);
        menuIdioma.add(itemEn);
        menuIdioma.add(itemFr);
        menuIdioma.add(itemIt);

        menuBar.add(menuIdioma);
        setJMenuBar(menuBar);
    }

    private void trocarIdioma(Locale locale) {
        carregarIdioma(locale);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tx.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, bn.getString("mensagem.valor.nulo"), bn.getString("tela1.erro.titulo"), JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int n = Integer.parseInt(tx.getText());
                n *= n;
                tx.setText("" + n);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, bn.getString("mensagem.valor.nulo"), bn.getString("tela1.erro.titulo"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}