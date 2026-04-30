import javax.swing.JOptionPane;
public class TesteClasses {
    public static void main(String[] args) {
        String nomeDoPagador = "Pessoa Exemplo";
        String cpf = "123.456.789-00";
        double valorASerPago = 100.00;
        String numeroDoBoleto = "1234567890";
        int dia = 15;
        int mes = 6;
        int ano = 2024;
        Boleto boleto = new Boleto(nomeDoPagador, cpf, valorASerPago, numeroDoBoleto, dia, mes, ano); // Criação de um objeto do tipo Boleto
        JOptionPane.showMessageDialog(null, "Nome do Pagador: " + boleto.getNomeDoPagador() + "\nCPF: " + boleto.getCpf() + "\nValor a ser Pago: R$" + boleto.getValorASerPago() + "\nNúmero do Boleto: " + boleto.getNumeroDoBoleto() + "\nData de Vencimento: " + boleto.getDia() + "/" + boleto.getMes() + "/" + boleto.getAno()); // Exibição dos dados do boleto em uma caixa de diálogo

        double valorASerPago2 = 200.00;
        String numeroDoCartao = "1234 5678 9012 3456";
        CartaoDeCredito cartao = new CartaoDeCredito(nomeDoPagador, cpf, valorASerPago2, numeroDoCartao); // Criação de um objeto do tipo CartaoDeCredito
        JOptionPane.showMessageDialog(null, "Nome do Pagador: " + cartao.getNomeDoPagador() + "\nCPF: " + cartao.getCpf() + "\nValor a ser Pago: R$" + cartao.getValorASerPago() + "\nNúmero do Cartão: " + cartao.getNumeroDoCartao()); // Exibição dos dados do cartão de crédito em uma caixa de diálogo

        double valorASerPago3 = 300.00;
        String numeroDoCheque = "9876543210";
        Cheque cheque = new Cheque(nomeDoPagador, cpf, valorASerPago3, numeroDoCheque);
        JOptionPane.showMessageDialog(null, "Nome do Pagador: " + cheque.getNomeDoPagador() + "\nCPF: " + cheque.getCpf() + "\nValor a ser Pago: R$" + cheque.getValorASerPago() + "\nNúmero do Cheque: " + cheque.getNumeroDoCheque()); // Exibição dos dados do cheque em uma caixa de diálogo
    }
}