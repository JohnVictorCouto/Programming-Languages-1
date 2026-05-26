import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Professor {
    private String nome;
    private int idade;
    private int matricula;

    // Construtores
    public Professor() {
        this.nome = "";
        this.idade = 0;
        this.matricula = 0;
    }

    public Professor(int matricula) {
        this.nome = "";
        this.idade = 0;
        this.matricula = matricula;
    }

    public Professor(String nome, int idade, int matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    @Override
    public String toString() {
        return "Professor{nome='" + nome + "', idade=" + idade + ", matricula=" + matricula + '}';
    }

    // --- Métodos de Persistência ---

    public void inserir(Connection conn) {
        String sql = "INSERT INTO professor(matricula, nome, idade) VALUES(?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            stmt.setString(2, nome);
            stmt.setInt(3, idade);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            realizarRollback(conn);
            throw new RuntimeException("Erro ao inserir professor: " + ex.getMessage(), ex);
        }
    }

    public void alterar(Connection conn) {
        String sql = "UPDATE professor SET nome = ?, idade = ? WHERE matricula = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setInt(3, matricula);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            realizarRollback(conn);
            throw new RuntimeException("Erro ao alterar professor: " + ex.getMessage(), ex);
        }
    }

    public void excluir(Connection conn) {
        String sql = "DELETE FROM professor WHERE matricula = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            realizarRollback(conn);
            throw new RuntimeException("Erro ao excluir professor: " + ex.getMessage(), ex);
        }
    }

    public boolean carregar(Connection conn) {
        String sql = "SELECT nome, idade FROM professor WHERE matricula = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.nome = rs.getString("nome");
                    this.idade = rs.getInt("idade");
                    return true;
                }
                return false;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao carregar professor: " + ex.getMessage(), ex);
        }
    }

    public static ArrayList<Professor> buscarTodos(Connection conn) {
        String sql = "SELECT matricula, nome, idade FROM professor";
        ArrayList<Professor> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Professor p = new Professor();
                p.setMatricula(rs.getInt("matricula"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar professores: " + ex.getMessage(), ex);
        }
        return lista;
    }

    // Método auxiliar para evitar repetição de código no rollback
    private void realizarRollback(Connection conn) {
        try {
            if (conn != null) conn.rollback();
        } catch (SQLException e) {
            System.err.println("Erro crítico: falha no rollback. " + e.getMessage());
        }
    }
}