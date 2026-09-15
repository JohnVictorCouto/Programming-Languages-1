import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class TelaMEDIA extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;
    private AlunoDAO dao;
    private int loginId;
    private String usuario;
    private JLabel lblUltimaAlteracao;
    private boolean modificandoTabela = false; 
    private ResourceBundle bundle;

    public TelaMEDIA(int loginId, String usuario) {
        this.loginId = loginId;
        this.usuario = usuario;
        this.dao = new AlunoDAO();
        this.bundle = TelaEntrada.getBundle(); // Pega o idioma escolhido na tela de login

        setTitle(bundle.getString("tela.notas.titulo") + usuario);
        setSize(1250, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        criarTela();
        carregarDoBD();
        setVisible(true);
    }

    private void criarTela() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] colunas = {
            bundle.getString("tabela.coluna.materia"), "P1", "P2", "T1", "P3", "P4", "T2",
            "MP", "MT", "MF", bundle.getString("tabela.coluna.faltas")
        };

        modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 7 && column != 8 && column != 9;
            }
        };

        tabela = new JTable(modelo);
        tabela.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        tabela.setRowHeight(28);
        tabela.getTableHeader().setReorderingAllowed(false);

        modelo.addTableModelListener(e -> {
            if (modificandoTabela) return;

            int linha = e.getFirstRow();
            int coluna = e.getColumn();

            if (linha >= 0 && coluna != 7 && coluna != 8 && coluna != 9) {
                recalcularLinha(linha);
            }
        });

        painel.add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel inferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        JButton btnLerBD = new JButton(bundle.getString("botao.ler.bd"));
        JButton btnSalvarBD = new JButton(bundle.getString("botao.salvar.bd"));
        JButton btnSair = new JButton(bundle.getString("botao.sair"));

        lblUltimaAlteracao = new JLabel(bundle.getString("label.ultima.alteracao.nenhuma"));

        btnLerBD.addActionListener(e -> carregarDoBD());
        btnSalvarBD.addActionListener(e -> salvarNoBD());
        btnSair.addActionListener(e -> {
            dispose();
            new TelaEntrada().setVisible(true);
        });

        inferior.add(btnLerBD);
        inferior.add(btnSalvarBD);
        inferior.add(btnSair);
        inferior.add(lblUltimaAlteracao);

        painel.add(inferior, BorderLayout.SOUTH);
        add(painel);
    }

    private void recalcularLinha(int linha) {
        try {
            modificandoTabela = true;

            String nome = String.valueOf(modelo.getValueAt(linha, 0));
            double p1 = lerDouble(linha, 1);
            double p2 = lerDouble(linha, 2);
            double t1 = lerDouble(linha, 3);
            double p3 = lerDouble(linha, 4);
            double p4 = lerDouble(linha, 5);
            double t2 = lerDouble(linha, 6);
            int faltas = lerInteiro(linha, 10); 

            Materia mTemp = new Materia(nome, p1, p2, p3, p4, t1, t2, faltas);

            modelo.setValueAt(String.format("%.2f", mTemp.calcularMP()), linha, 7);
            modelo.setValueAt(String.format("%.2f", mTemp.calcularMT()), linha, 8);
            modelo.setValueAt(String.format("%.2f", mTemp.calcularMF()), linha, 9);

        } catch (Exception ex) {
            // Ignora erros de digitação temporários durante a edição
        } finally {
            modificandoTabela = false;
        }
    }

    private void carregarDoBD() {
        try {
            modificandoTabela = true;
            modelo.setRowCount(0);

            Aluno aluno = dao.lerDoBD(loginId);

            if (aluno == null || aluno.getMaterias() == null || aluno.getMaterias().isEmpty()) {
                aluno = new Aluno();
            }

            for (Materia m : aluno.getMaterias()) {
                modelo.addRow(new Object[] {
                    m.getNome(),
                    m.getP1(),
                    m.getP2(),
                    m.getT1(),
                    m.getP3(),
                    m.getP4(),
                    m.getT2(),
                    String.format("%.2f", m.calcularMP()),
                    String.format("%.2f", m.calcularMT()),
                    String.format("%.2f", m.calcularMF()),
                    m.getFaltas()
                });
            }

            atualizarDataAlteracao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, bundle.getString("msg.erro.visual"));
            e.printStackTrace();
        } finally {
            modificandoTabela = false;
        }
    }

    private void salvarNoBD() {
        if (tabela.isEditing()) {
            tabela.getCellEditor().stopCellEditing();
        }

        try {
            Aluno aluno = new Aluno();
            int totalLinhas = Math.min(modelo.getRowCount(), 4);
            
            if (totalLinhas == 0) {
                JOptionPane.showMessageDialog(this, bundle.getString("msg.sem.linhas"));
                return;
            }

            for (int i = 0; i < totalLinhas; i++) {
                String nome = String.valueOf(modelo.getValueAt(i, 0));
                double p1 = lerDouble(i, 1);
                double p2 = lerDouble(i, 2);
                double t1 = lerDouble(i, 3);
                double p3 = lerDouble(i, 4);
                double p4 = lerDouble(i, 5);
                double t2 = lerDouble(i, 6);
                int faltas = lerInteiro(i, 10);
                
                aluno.setMateria(i, new Materia(nome, p1, p2, p3, p4, t1, t2, faltas));
            }

            if (dao.salvar(aluno, loginId)) {
                carregarDoBD();
                JOptionPane.showMessageDialog(this, bundle.getString("msg.salvar.sucesso"));
            } else {
                JOptionPane.showMessageDialog(this, bundle.getString("msg.salvar.erro"));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("msg.erro.numero"));
        }
    }

    private double lerDouble(int linha, int coluna) {
        Object valor = modelo.getValueAt(linha, coluna);
        if (valor == null || String.valueOf(valor).trim().isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(String.valueOf(valor).replace(',', '.'));
    }

    private int lerInteiro(int linha, int coluna) {
        Object valor = modelo.getValueAt(linha, coluna);
        if (valor == null || String.valueOf(valor).trim().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(String.valueOf(valor).trim());
    }

    private void atualizarDataAlteracao() {
        Timestamp timestamp = dao.getUltimaAlteracao(loginId);

        if (timestamp == null) {
            lblUltimaAlteracao.setText(bundle.getString("label.ultima.alteracao.nenhuma"));
        } else {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            lblUltimaAlteracao.setText(bundle.getString("label.ultima.alteracao") + formato.format(timestamp));
        }
    }
}