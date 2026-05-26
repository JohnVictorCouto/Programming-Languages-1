import java.sql.*;

public class ContaCorrente {
    private int numero;
    private int digito;
    private Agencia agencia;
    private double saldo;

    public ContaCorrente(int numero, Agencia agencia, double saldo) {
        setNumero(numero);
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) {
        if (numero > 0 && numero <= 9999) {
            this.numero = numero;
            this.digito = Agencia.calcularMod11(numero);
        }
    }

    public int getDigito() { return digito; }
    public Agencia getAgencia() { return agencia; }
    public void setAgencia(Agencia agencia) { this.agencia = agencia; }

    public void depositar(double valor) { this.saldo += valor; }

    public double sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Saque não efetuado: saldo insuficiente.");
            return 0;
        }
        this.saldo -= valor;
        return valor;
    }

    public double consultarSaldo() { return saldo; }

    public void imprimirSaldo() {
        System.out.println("Agência: " + agencia.getNumero() + "-" + agencia.getDigito());
        System.out.println("Conta: " + numero + "-" + digito + " | Saldo: " + saldo);
    }

    // Persistência: numero (pk), digito
    public void inserir(Connection conn) throws SQLException {
        String sql = "INSERT INTO conta_corrente (numero, digito) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            stmt.setInt(2, digito);
            stmt.executeUpdate();
        }
    }

    public void atualizar(Connection conn) throws SQLException {
        String sql = "UPDATE conta_corrente SET digito = ? WHERE numero = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, digito);
            stmt.setInt(2, numero);
            stmt.executeUpdate();
        }
    }

    public void excluir(Connection conn) throws SQLException {
        String sql = "DELETE FROM conta_corrente WHERE numero = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            stmt.executeUpdate();
        }
    }
}
