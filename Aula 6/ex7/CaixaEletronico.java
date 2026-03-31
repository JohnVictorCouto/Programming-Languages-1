import javax.swing.JOptionPane;

public class CaixaEletronico {

    public static void main(String[] args) {

        // Dados do enunciado
        Agencia agencia = new Agencia("Agencia Central", 7890);
        ContaCorrente conta = new ContaCorrente(1234, agencia, 150.00);
        Cliente cliente = new Cliente("Ademar Apior", "123231518-12", conta);

        int opcao = -1;

        while (opcao != 0) {

            String menu = "=== CAIXA ELETRÔNICO ===\n"
                    + "Cliente: " + cliente.getNome() + "\n\n"
                    + "1 - Sacar\n"
                    + "2 - Depositar\n"
                    + "3 - Consultar saldo\n"
                    + "4 - Imprimir dados\n"
                    + "0 - Sair\n\n"
                    + "Escolha uma opção:";

            try {

                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcao) {
                    case 1:
                        double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque:"));
                        double retorno = conta.sacar(valorSaque);

                        if (retorno == 0) {
                            JOptionPane.showMessageDialog(null,"Saque não efetuado! Saldo insuficiente.");
                        } else {
                            JOptionPane.showMessageDialog(null,"Saque realizado com sucesso!");
                        }
                        break;

                    case 2:
                        double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do depósito:"));
                        conta.depositar(valorDeposito);
                        JOptionPane.showMessageDialog(null,"Depósito realizado com sucesso!");
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null,"Saldo atual: R$ " + String.format("%.2f", conta.consultarSaldo()));
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null,
                                "Cliente: " + cliente.getNome() +
                                "\nCPF: " + cliente.getCpf() +
                                "\nConta: " + conta.getNumero() + "-" + conta.getDigito() +
                                "\nAgência: " + agencia.getNumero() + "-" + agencia.getDigito() +
                                "\nSaldo: R$ " + String.format("%.2f", conta.consultarSaldo()));
                        break;

                    case 0:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!");
            }
        }
    }
}