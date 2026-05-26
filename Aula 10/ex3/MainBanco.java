import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

public class MainBanco {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 1. Conexão
            conn = ConnFactory.getConn();
            JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!", "Status BD", JOptionPane.INFORMATION_MESSAGE);

            // 2. Entrada de dados via JOptionPane
            String nomeAgencia = JOptionPane.showInputDialog("Nome da Agência:");
            int numAgencia = Integer.parseInt(JOptionPane.showInputDialog("Número da Agência (máx 4 dígitos):"));
            Agencia ag = new Agencia(nomeAgencia, numAgencia);

            int numConta = Integer.parseInt(JOptionPane.showInputDialog("Número da Conta (máx 4 dígitos):"));
            double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Saldo Inicial:"));
            ContaCorrente cc = new ContaCorrente(numConta, ag, saldoInicial);

            String nomeCli = JOptionPane.showInputDialog("Nome do Cliente:");
            String cpfCli = JOptionPane.showInputDialog("CPF do Cliente:");
            Cliente cliente = new Cliente(nomeCli, cpfCli, cc);

            // 3. Testar Operações Bancárias
            double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor para Depósito:"));
            cc.depositar(deposito);

            double saque = Double.parseDouble(JOptionPane.showInputDialog("Valor para Saque:"));
            double valorRetornado = cc.sacar(saque);
            
            if(valorRetornado > 0) {
                JOptionPane.showMessageDialog(null, "Saque de R$ " + valorRetornado + " realizado com sucesso!");
            }

            // 4. Imprimir Saldo
            String relatorio = "Agência: " + ag.getNumero() + "-" + ag.getDigito() +
                               "\nConta: " + cc.getNumero() + "-" + cc.getDigito() +
                               "\nSaldo Atual: R$ " + cc.consultarSaldo();
            
            JOptionPane.showMessageDialog(null, relatorio, "Relatório da Conta", JOptionPane.INFORMATION_MESSAGE);

            // 5. Persistência
            int confirmar = JOptionPane.showConfirmDialog(null, "Deseja salvar os dados no banco de dados?", "Persistência", JOptionPane.YES_NO_OPTION);
            
            if (confirmar == JOptionPane.YES_OPTION) {
                ag.inserir(conn);
                cc.inserir(conn);
                cliente.inserir(conn);
                
                // Testar Alteração
                String novoNome = JOptionPane.showInputDialog("Deseja alterar o nome do cliente para persistência?", cliente.getNome());
                cliente.setNome(novoNome);
                cliente.atualizar(conn);

                conn.commit();
                JOptionPane.showMessageDialog(null, "Dados salvos e transação confirmada!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (conn != null) {
                ConnFactory.closeConn(conn);
            }
        }
    }
}
