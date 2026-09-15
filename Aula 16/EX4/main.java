import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main extends JFrame {
    
    // Componentes da interface
    private JTextField txtRaBusca;
    private JTextArea txtResultado;
    private JButton btnBuscar;

    public main() {
        super("Consulta de Aluno por RA");
        
        setLayout(new BorderLayout(10, 10));

        JPanel painelBusca = new JPanel(new FlowLayout());
        painelBusca.add(new JLabel("Digite o RA:"));
        
        txtRaBusca = new JTextField(15);
        painelBusca.add(txtRaBusca);
        
        btnBuscar = new JButton("Buscar");
        painelBusca.add(btnBuscar);
        
        add(painelBusca, BorderLayout.NORTH);

        txtResultado = new JTextArea(8, 30);
        txtResultado.setEditable(false); 
        txtResultado.setFont(new Font("Monospaced", Font.BOLD, 14)); 
        
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultado da Consulta"));
        
        add(scrollPane, BorderLayout.CENTER);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAlunoPorRa();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); 
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void buscarAlunoPorRa() {
        String raDigitado = txtRaBusca.getText().trim();
        
        if (raDigitado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um RA para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean raEncontrado = false;
        Scanner leitorArquivo = null;

        try {
            leitorArquivo = new Scanner(new File("alunos.txt"));

            while (leitorArquivo.hasNextLine()) {
                String linha = leitorArquivo.nextLine();
                
                String[] dados = linha.split(",");

                if (dados.length == 7) {
                    String raNoArquivo = dados[0];
                    
                    if (raNoArquivo.equals(raDigitado)) {
                        raEncontrado = true;
                        
                        String nome = dados[1];
                        String sobrenome = dados[2];
                        
                        double p1 = Double.parseDouble(dados[3]);
                        double p2 = Double.parseDouble(dados[4]);
                        double p3 = Double.parseDouble(dados[5]);
                        double p4 = Double.parseDouble(dados[6]);
                        
                        double media = (p1 + p2 + p3 + p4) / 4.0;

                        String resposta = String.format(
                                "RA: %s\nNOME: %s\nSOBRENOME: %s\nMÉDIA: %.2f", 
                                raNoArquivo, nome, sobrenome, media
                        );
                        
                        txtResultado.setText(resposta);
                        break; 
                    }
                }
            }

            if (!raEncontrado) {
                txtResultado.setText("RA NÃO CADASTRADO");
            }

        } catch (FileNotFoundException ex) {
            txtResultado.setText("Erro: Arquivo 'alunos.txt' não encontrado.\nRealize cadastros primeiro.");
        } catch (NumberFormatException ex) {
            txtResultado.setText("Erro na leitura: As notas cadastradas não são números válidos.");
        } finally {
            if (leitorArquivo != null) {
                leitorArquivo.close();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new main());
    }
}