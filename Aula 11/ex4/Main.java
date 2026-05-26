import javax.swing.*; 
import java.awt.*;   

public class Main extends JFrame { 
    // Declaração dos campos de texto para entrada de dados
    private JTextField txtNome, txtSobrenome, txtCpf, txtV1, txtV2;
    // Declaração dos rótulos que mudarão o texto dinamicamente
    private JLabel lblV1, lblV2;
    // Declaração do menu suspenso para escolha da categoria
    private JComboBox<String> cbTipo;

    public Main() { // Método construtor da janela
        setTitle("Sistema de Cadastro - Pessoa Física"); // Define o texto da barra de título
        setSize(450, 400); // Define a dimensão da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Finaliza o processo ao fechar a janela
        setLayout(new GridLayout(8, 2, 10, 10)); // Organiza em 8 linhas e 2 colunas com espaçamento de 10px

        // Cria o rótulo "Nome", campo de texto correspondente e adiciona à janela
        add(new JLabel(" Nome:")); txtNome = new JTextField(); add(txtNome);
        // Cria o rótulo "Sobrenome", campo de texto correspondente e adiciona à janela
        add(new JLabel(" Sobrenome:")); txtSobrenome = new JTextField(); add(txtSobrenome);
        // Cria o rótulo "CPF", campo de texto correspondente e adiciona à janela
        add(new JLabel(" CPF:")); txtCpf = new JTextField(); add(txtCpf);
        
        // Cria o rótulo "Categoria" e configura o JComboBox com as opções das classes
        add(new JLabel(" Categoria:"));
        cbTipo = new JComboBox<>(new String[]{
            "Desempregado", "Mensalista", "Comissionado", "Horista", "Tarefeiro"
        });
        add(cbTipo); // Adiciona o seletor à janela

        // Inicializa o primeiro campo variável
        lblV1 = new JLabel(" Seguro Desemprego:"); add(lblV1);
        txtV1 = new JTextField(); add(txtV1);
        
        // Inicializa o segundo campo variável
        lblV2 = new JLabel(" - "); add(lblV2);
        txtV2 = new JTextField(); add(txtV2);
        
        // Configura o estado inicial da tela ocultando o segundo campo variável
        lblV2.setVisible(false); txtV2.setVisible(false);

        // Cria o botão de processamento e adiciona à janela
        JButton btnProcessar = new JButton("Gerar Dados");
        add(btnProcessar);

        // Define a ação disparada ao mudar a opção no JComboBox
        cbTipo.addActionListener(e -> atualizarLabels());
        // Define a ação disparada ao clicar no botão "Gerar Dados"
        btnProcessar.addActionListener(e -> processar());
    }

    private void atualizarLabels() { // Método para adaptar os campos conforme a categoria escolhida
        String selecionado = (String) cbTipo.getSelectedItem(); // Obtém o item selecionado no menu
        // Torna os campos variáveis visíveis para serem reconfigurados
        lblV2.setVisible(true); txtV2.setVisible(true);

        switch (selecionado) { // Verifica a categoria para ajustar os textos
            case "Desempregado" -> {
                lblV1.setText(" Seguro Desemprego:");
                lblV2.setVisible(false); txtV2.setVisible(false); // Esconde o segundo campo
            }
            case "Mensalista" -> {
                lblV1.setText(" Salário Mensal:");
                lblV2.setVisible(false); txtV2.setVisible(false); // Esconde o segundo campo
            }
            case "Comissionado" -> {
                lblV1.setText(" Salário Base:");
                lblV2.setText(" Comissão:");
            }
            case "Horista" -> {
                lblV1.setText(" Valor da Hora:");
                lblV2.setText(" Horas Trabalhadas:");
            }
            case "Tarefeiro" -> {
                lblV1.setText(" Valor por Tarefa:");
                lblV2.setText(" Qtd de Tarefas:");
            }
        }
        revalidate(); repaint(); // Comandos para atualizar o layout visual da janela
    }

        private void processar() { // Método que lê os dados e gera o objeto polimórfico
        try {
            // Captura os dados básicos comuns de PessoaFisica
            String n = txtNome.getText();
            String s = txtSobrenome.getText();
            String c = txtCpf.getText();
            double v1 = Double.parseDouble(txtV1.getText()); // Converte entrada de texto para número
            
            PessoaFisica pessoa = null; // Declara a variável do tipo pai 
            String tipo = (String) cbTipo.getSelectedItem(); // Identifica o tipo para instanciar

            // Lógica de polimorfismo
            switch (tipo) {
                case "Desempregado" -> pessoa = new Desempregado(n, s, c, v1);
                case "Mensalista" -> pessoa = new Mensalista(n, s, c, v1);
                case "Comissionado" -> {
                    double v2 = Double.parseDouble(txtV2.getText()); // Captura o segundo valor
                    pessoa = new Comissionado(n, s, c, v1, v2);
                }
                case "Horista" -> {
                    double v2 = Double.parseDouble(txtV2.getText());
                    pessoa = new Horista(n, s, c, v1, v2);
                }
                case "Tarefeiro" -> {
                    double v2 = Double.parseDouble(txtV2.getText());
                    pessoa = new Tarefeiro(n, s, c, v1, (int)v2); // Cast para int na quantidade
                }
            }

            if (pessoa != null) { // Se o objeto foi criado com sucesso
                String mensagemCompleta = pessoa.dados();
                
                // CORREÇÃO: Se o objeto for qualquer tipo de Empregado, extrai o salário dinâmico
                if (pessoa instanceof Empregado) {
                    Empregado emp = (Empregado) pessoa;
                    mensagemCompleta += String.format("\nSalário: R$ %.2f", emp.salario());
                }
                
                // Exibe a mensagem final com todas as informações na tela
                JOptionPane.showMessageDialog(this, mensagemCompleta);
            }
        } catch (Exception ex) { // Trata erros de preenchimento
            JOptionPane.showMessageDialog(this, "Erro: Verifique os campos numéricos.");
        }
    }

    public static void main(String[] args) { 
        new Main().setVisible(true); // Instancia a classe e torna a janela visível
    }
}