import javax.swing.JOptionPane;

public class TesteContaBancaria {
    public static void main(String[] args){

        ContaBancaria conta = null; // Variável para armazenar a conta bancária criada
        int escolha; // Variável para armazenar a escolha do usuário

        do { // Loop para exibir o menu até que o usuário escolha sair
            escolha = Integer.parseInt(JOptionPane.showInputDialog(
                "Escolha uma opção:\n" +
                "1 - Criar conta\n" +
                "2 - Depositar\n" +
                "3 - Sacar\n" +
                "4 - Ver dados\n" +
                "5 - Sair"
            ));

            switch (escolha) { // Estrutura de controle para executar a ação escolhida pelo usuário
                case 1:
                    int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:")); // Solicita o número da conta ao usuário
                    String nomeTitular = JOptionPane.showInputDialog("Digite o nome do titular da conta:"); // Solicita o nome do titular da conta ao usuário
                    double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial:")); // Solicita o saldo inicial da conta ao usuário

                    conta = new ContaBancaria(numeroConta, nomeTitular, saldo); // Cria uma nova conta bancária com os dados fornecidos pelo usuário
                    JOptionPane.showMessageDialog(null, "Conta criada com sucesso!"); // Exibe uma mensagem de sucesso para o usuário
                    break;

                case 2:
                    if (conta != null) {
                        double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado:")); // Solicita o valor do depósito ao usuário
                        if (valorDeposito <= 0) { // Verifica se o valor do depósito é negativo ou zero, o que não é permitido
                            JOptionPane.showMessageDialog(null, "Valor de depósito deve ser positivo!");
                        } else { // Se o valor do depósito for válido, realiza o depósito na conta
                            conta.depositar(valorDeposito);
                        }
                    } else { // Se a conta não tiver sido criada, exibe uma mensagem de erro para o usuário
                        JOptionPane.showMessageDialog(null, "Crie uma conta primeiro!");
                    }
                    break;

                case 3:
                    if (conta != null) { // Verifica se a conta foi criada antes de permitir o saque
                        double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser sacado:")); // Solicita o valor do saque ao usuário
                        if (valorSaque > conta.getSaldo()) { // Verifica se o valor do saque é maior do que o saldo disponível na conta, o que não é permitido
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente!"); // Exibe uma mensagem de erro para o usuário
                        } else { // Se o valor do saque for válido, realiza o saque na conta
                            conta.sacar(valorSaque); 
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Crie uma conta primeiro!"); // Se a conta não tiver sido criada, exibe uma mensagem de erro para o usuário
                    }
                    break;

                case 4:
                    if (conta != null) { // Verifica se a conta foi criada antes de exibir os dados da conta
                        JOptionPane.showMessageDialog(null, "Dados da conta:\n" +
                                "Número: " + conta.getNumeroConta() + "\n" +
                                "Titular: " + conta.getNomeTitular() + "\n" +
                                "Saldo: " + conta.getSaldo());
                    } else { // Se a conta não tiver sido criada, exibe uma mensagem de erro para o usuário
                        JOptionPane.showMessageDialog(null, "Crie uma conta primeiro!");
                    }
                    break;

                case 5: // Opção para sair do programa
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;

                default: // Se o usuário escolher uma opção inválida, exibe uma mensagem de erro para o usuário
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (escolha != 5); // O loop continua até que o usuário escolha a opção de sair (5)
    }
}