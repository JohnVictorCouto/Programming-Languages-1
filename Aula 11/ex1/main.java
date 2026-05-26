import javax.swing.*;
import java.awt.*;    

public class main {
    public static void main(String[] args) {
        // Cria a janela principal 
        JFrame frame = new JFrame("Exercício 1");
        
        // Define que o programa deve fechar totalmente ao clicar no "X" da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Define o tamanho inicial da janela 
        frame.setSize(400, 150);
        
        // Define o layout como FlowLayout
        frame.setLayout(new FlowLayout());

        // Cria o rótulo (etiqueta) com o nome "Texto:"
        JLabel label = new JLabel("Texto:");
        
        // Cria o campo de entrada de texto com largura para aproximadamente 20 caracteres
        JTextField campoTexto = new JTextField(20);
        
        // Cria os botões com seus respectivos nomes
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnSair = new JButton("Sair");

        // Define o que acontece ao clicar no botão "Mostrar"
        btnMostrar.addActionListener(e -> {
            // Pega o texto que o usuário digitou no campo
            String conteudo = campoTexto.getText();
            // Abre uma pequena janela de aviso mostrando esse texto
            JOptionPane.showMessageDialog(frame, "Conteúdo: " + conteudo);
        });

        // Define o que acontece ao clicar no botão "Limpar"
        btnLimpar.addActionListener(e -> {
            // Substitui o texto do campo por uma string vazia (limpa o campo)
            campoTexto.setText("");
        });

        // Define o que acontece ao clicar no botão "Sair"
        btnSair.addActionListener(e -> {
            // Encerra a execução da Máquina Virtual Java (fecha o programa)
            System.exit(0);
        });

        // Adiciona cada componente criado dentro da janela (frame)
        frame.add(label);
        frame.add(campoTexto);
        frame.add(btnMostrar);
        frame.add(btnLimpar);
        frame.add(btnSair);

        // Faz com que a janela apareça exatamente no centro da tela do computador
        frame.setLocationRelativeTo(null);
        
        // Torna a janela visível para o usuário
        frame.setVisible(true);
    }
}