import java.sql.*;

public class Agencia {
    private String nome;
    private int numero;
    private int digito;

    public Agencia(String nome, int numero) {
        this.nome = nome;
        setNumero(numero);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) {
        if (numero > 0 && numero <= 9999) {
            this.numero = numero;
            this.digito = calcularMod11(numero);
        }
    }

    public int getDigito() { return digito; }

    public static int calcularMod11(int num) {
        int d4 = num % 10;
        int d3 = (num / 10) % 10;
        int d2 = (num / 100) % 10;
        int d1 = (num / 1000) % 10;
        int soma = (d1 * 4) + (d2 * 6) + (d3 * 8) + (d4 * 2);
        int resto = soma % 11;
        return (resto == 10) ? 0 : resto;
    }

    // Persistência: numero (pk), digito
    public void inserir(Connection conn) throws SQLException {
        String sql = "INSERT INTO agencia (numero, digito) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            stmt.setInt(2, digito);
            stmt.executeUpdate();
        }
    }

    public void atualizar(Connection conn) throws SQLException {
        String sql = "UPDATE agencia SET digito = ? WHERE numero = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, digito);
            stmt.setInt(2, numero);
            stmt.executeUpdate();
        }
    }

    public void excluir(Connection conn) throws SQLException {
        String sql = "DELETE FROM agencia WHERE numero = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            stmt.executeUpdate();
        }
    }
}