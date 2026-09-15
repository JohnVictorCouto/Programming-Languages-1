import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class main extends JFrame {
    
    private JTextField txtRa, txtNome, txtSobrenome, txtP1, txtP2, txtP3, txtP4;
    private JButton btnSalvar;

    public main() {
        super("Cadastro de Alunos");
        
        setLayout(new BorderLayout());

        JPanel painelFormulario = new JPanel(new GridLayout(7, 2, 5, 5));
        
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelFormulario.add(new JLabel("RA:"));
        txtRa = new JTextField();
        painelFormulario.add(txtRa);

        painelFormulario.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelFormulario.add(txtNome);

        painelFormulario.add(new JLabel("Sobrenome:"));
        txtSobrenome = new JTextField();
        painelFormulario.add(txtSobrenome);

        painelFormulario.add(new JLabel("Nota P1:"));
        txtP1 = new JTextField();
        painelFormulario.add(txtP1);

        painelFormulario.add(new JLabel("Nota P2:"));
        txtP2 = new JTextField();
        painelFormulario.add(txtP2);

        painelFormulario.add(new JLabel("Nota P3:"));
        txtP3 = new JTextField();
        painelFormulario.add(txtP3);

        painelFormulario.add(new JLabel("Nota P4:"));
        txtP4 = new JTextField();
        painelFormulario.add(txtP4);

        add(painelFormulario, BorderLayout.CENTER);

        JPanel painelBotao = new JPanel(); 
        btnSalvar = new JButton("Gravar Dados");
        painelBotao.add(btnSalvar);
        
        add(painelBotao, BorderLayout.SOUTH);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarDados();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 350);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private void salvarDados() {
        String ra = txtRa.getText();
        String nome = txtNome.getText();
        String sobrenome = txtSobrenome.getText();
        String p1 = txtP1.getText();
        String p2 = txtP2.getText();
        String p3 = txtP3.getText();
        String p4 = txtP4.getText();

        if(ra.isEmpty() || nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha pelo menos o RA e o Nome!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Formatter output = null;
        try {
            output = new Formatter(new FileWriter("alunos.txt", true));
            
            output.format("%s,%s,%s,%s,%s,%s,%s\n", ra, nome, sobrenome, p1, p2, p3, p4);
            
            JOptionPane.showMessageDialog(this, "Dados gravados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gravar no arquivo de texto.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    private void limparCampos() {
        txtRa.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        txtP1.setText("");
        txtP2.setText("");
        txtP3.setText("");
        txtP4.setText("");
        txtRa.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new main());
    }

}