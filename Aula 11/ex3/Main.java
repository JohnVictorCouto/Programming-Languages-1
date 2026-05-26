import javax.swing.*; 
import java.awt.*;   

public class Main extends JFrame { // Classe principal que herda de JFrame
    // Declaração dos campos de entrada de texto
    private JTextField txtNome, txtSobrenome, txtCpf, txtValor1, txtValor2;
    // Declaração dos rótulos que mudam dinamicamente
    private JLabel lblValor1, lblValor2;
    // Declaração da caixa de seleção para escolher o tipo de empregado
    private JComboBox<String> cbTipo;

    public Main() { // Construtor da janela
        setTitle("Cadastro de Empregados"); // Define o título da barra da janela
        setSize(400, 350); // Define a largura (400) e altura (350) da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
        setLayout(new GridLayout(7, 2, 10, 10)); // Organiza em grade: 7 linhas, 2 colunas, 10px de espaço

        // Adiciona rótulo e campo de texto para o Nome
        add(new JLabel(" Nome:")); txtNome = new JTextField(); add(txtNome);
        // Adiciona rótulo e campo de texto para o Sobrenome
        add(new JLabel(" Sobrenome:")); txtSobrenome = new JTextField(); add(txtSobrenome);
        // Adiciona rótulo e campo de texto para o CPF
        add(new JLabel(" CPF:")); txtCpf = new JTextField(); add(txtCpf);
        
        // Adiciona rótulo e a caixa de seleção com as opções de classes
        add(new JLabel(" Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Mensalista", "Comissionado", "Horista", "Tarefeiro"});
        add(cbTipo);

        // Configura o primeiro campo variável 
        lblValor1 = new JLabel(" Salário:"); add(lblValor1);
        txtValor1 = new JTextField(); add(txtValor1);
        
        // Configura o segundo campo variável
        lblValor2 = new JLabel(" Comissão:"); add(lblValor2);
        txtValor2 = new JTextField(); add(txtValor2);
        
        // Esconde o segundo campo por padrão 
        txtValor2.setVisible(false); lblValor2.setVisible(false);

        // Cria e adiciona o botão que executará o cálculo
        JButton btnCalcular = new JButton("Calcular Salário");
        add(btnCalcular);

        // Adiciona um "escutador" que roda a função atualizarInterface sempre que o tipo muda
        cbTipo.addActionListener(e -> atualizarInterface());

        // Adiciona um "escutador" que roda a função calcular quando o botão é clicado
        btnCalcular.addActionListener(e -> calcular());
    }

    private void atualizarInterface() { // Método para mudar os nomes dos campos conforme a classe
        String selecionado = (String) cbTipo.getSelectedItem(); // Pega o texto selecionado no Combo
        txtValor2.setVisible(true); lblValor2.setVisible(true); // Torna o segundo campo visível por padrão

        switch (selecionado) { // Verifica qual tipo foi escolhido
            case "Mensalista" -> { 
                lblValor1.setText(" Salário:"); // Muda texto para Salário
                txtValor2.setVisible(false); lblValor2.setVisible(false); // Esconde campo desnecessário
            }
            case "Comissionado" -> { 
                lblValor1.setText(" Salário Base:"); // Muda texto 1
                lblValor2.setText(" Comissão:"); // Muda texto 2
            }
            case "Horista" -> { 
                lblValor1.setText(" Valor Hora:"); // Muda texto 1
                lblValor2.setText(" Horas Trab.:"); // Muda texto 2
            }
            case "Tarefeiro" -> { 
                lblValor1.setText(" Valor Tarefa:"); // Muda texto 1
                lblValor2.setText(" Qtd Tarefas:"); // Muda texto 2
            }
        }
        revalidate(); repaint(); // Recalcula o layout e redesenha a tela para aplicar as mudanças
    }

    private void calcular() { // Método que cria o objeto e calcula o salário
        String nome = txtNome.getText(); // Pega o nome digitado
        String sobrenome = txtSobrenome.getText(); // Pega o sobrenome digitado
        String cpf = txtCpf.getText(); // Pega o CPF digitado
        double v1 = Double.parseDouble(txtValor1.getText()); // Converte o primeiro valor para número
        
        Empregado emp = null; // Cria uma variável pai (Empregado) para usar polimorfismo
        String tipo = (String) cbTipo.getSelectedItem(); // Verifica o tipo selecionado

        if (tipo.equals("Mensalista")) { // Se for mensalista
            emp = new Mensalista(nome, sobrenome, cpf, v1); // Instancia o objeto Mensalista
        } else {
            double v2 = Double.parseDouble(txtValor2.getText()); // Converte o segundo valor para número
            // Instancia a classe específica conforme a seleção
            if (tipo.equals("Comissionado")) emp = new Comissionado(nome, sobrenome, cpf, v1, v2);
            else if (tipo.equals("Horista")) emp = new Horista(nome, sobrenome, cpf, v1, v2);
            else if (tipo.equals("Tarefeiro")) emp = new Tarefeiro(nome, sobrenome, cpf, v1, (int)v2);
        }

        // Exibe uma caixa de mensagem com o resultado usando o método salario() da classe instanciada
        JOptionPane.showMessageDialog(this, "Empregado: " + nome + "\nSalário Final: R$ " + emp.salario());
    }

    public static void main(String[] args) { 
        new Main().setVisible(true); // Cria a janela e a torna visível ao usuário
    }
}
