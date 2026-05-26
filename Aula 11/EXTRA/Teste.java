import javax.swing.*;
import java.awt.*;

public class Teste {
    public static void main(String[] args) {
        Relogio relogio = new Relogio();

        // Configuração da Janela
        JFrame frame = new JFrame("Relógio Digital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // JLabel para o mostrador
        JLabel labelRelogio = new JLabel(relogio.mostra());
        
        labelRelogio.setFont(new Font("Monospaced", Font.BOLD, 60));
        // Cor da fonte
        labelRelogio.setForeground(new Color(255, 0, 0)); // Vermelho vivo

        // Criação dos botões
        JButton btnHora = new JButton("Hora");
        JButton btnMinuto = new JButton("Minuto");

        // Ação do botão Hora 
        btnHora.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Ajustar Hora (0-23):");
            if (input != null && !input.isEmpty()) {
                relogio.horas.setValor(Integer.parseInt(input));
                relogio.atualizarMostrador();
                labelRelogio.setText(relogio.mostra());
            }
        });

        // Ação do botão Minuto 
        btnMinuto.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Ajustar Minuto (0-59):");
            if (input != null && !input.isEmpty()) {
                relogio.minutos.setValor(Integer.parseInt(input));
                relogio.atualizarMostrador();
                labelRelogio.setText(relogio.mostra());
            }
        });

        // Adicionando à tela
        frame.add(labelRelogio);
        frame.add(btnHora);
        frame.add(btnMinuto);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while(true){
            relogio.ticTac();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            labelRelogio.setText(relogio.mostra());
        }
    }
}