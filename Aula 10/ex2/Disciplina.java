import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Disciplina {

    private String nome; 
    private String codigo;
    private ArrayList<Professor> professores;

    // Construtor padrão
    public Disciplina() {
        this.nome = "";
        this.codigo = "";
        this.professores = new ArrayList<>();
    }

    // Construtor com código
    public Disciplina(String codigo) {
        this.nome = "";
        this.codigo = codigo;
        this.professores = new ArrayList<>();
    }

    // Construtor completo
    public Disciplina(String nome,
                       String codigo,
                       ArrayList<Professor> professores) {

        this.nome = nome;
        this.codigo = codigo;
        this.professores = professores;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(
            ArrayList<Professor> professores) {

        this.professores = professores;
    }

    @Override
    public String toString() {

        return "Código: " + codigo +
               "\nNome: " + nome +
               "\nProfessores: " + professores;
    }

    // ==========================
    // MÉTODOS DE PERSISTÊNCIA
    // ==========================

    public void inserir(Connection conn) {

        String sql =
            "INSERT INTO disciplina(codigo, nome) " +
            "VALUES(?, ?)";

        try (PreparedStatement stmt =
                 conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);
            stmt.setString(2, nome);

            stmt.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {

            realizarRollback(conn);

            throw new RuntimeException(
                "Erro ao inserir disciplina: "
                + ex.getMessage(),
                ex
            );
        }
    }

    public void alterar(Connection conn) {

        String sql =
            "UPDATE disciplina " +
            "SET nome = ? " +
            "WHERE codigo = ?";

        try (PreparedStatement stmt =
                 conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, codigo);

            int linhas = stmt.executeUpdate();

            if (linhas == 0) {
                throw new RuntimeException(
                    "Disciplina não encontrada."
                );
            }

            conn.commit();

        } catch (SQLException ex) {

            realizarRollback(conn);

            throw new RuntimeException(
                "Erro ao alterar disciplina: "
                + ex.getMessage(),
                ex
            );
        }
    }

    public void excluir(Connection conn) {

        String sql =
            "DELETE FROM disciplina " +
            "WHERE codigo = ?";

        try (PreparedStatement stmt =
                 conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);

            int linhas = stmt.executeUpdate();

            if (linhas == 0) {
                throw new RuntimeException(
                    "Disciplina não encontrada."
                );
            }

            conn.commit();

        } catch (SQLException ex) {

            realizarRollback(conn);

            throw new RuntimeException(
                "Erro ao excluir disciplina: "
                + ex.getMessage(),
                ex
            );
        }
    }

    public boolean carregar(Connection conn) {

        String sql =
            "SELECT codigo, nome " +
            "FROM disciplina " +
            "WHERE codigo = ?";

        try (PreparedStatement stmt =
                 conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);

            try (ResultSet rs =
                     stmt.executeQuery()) {

                if (rs.next()) {

                    this.codigo =
                        rs.getString("codigo");

                    this.nome =
                        rs.getString("nome");

                    return true;
                }

                return false;
            }

        } catch (SQLException ex) {

            throw new RuntimeException(
                "Erro ao carregar disciplina: "
                + ex.getMessage(),
                ex
            );
        }
    }

    // ==========================
    // CARREGAR PROFESSORES
    // ==========================
    public void adicionarProfessor(
        Connection conn,
        Professor professor) {

    String sql =
        "INSERT INTO disciplina_professor " +
        "(codigo_disciplina, matricula_professor) " +
        "VALUES (?, ?)";

    try (PreparedStatement stmt =
             conn.prepareStatement(sql)) {

        stmt.setString(1, codigo);

        stmt.setInt(
            2,
            professor.getMatricula()
        );

        stmt.executeUpdate();

        professores.add(professor);

        conn.commit();

    } catch (SQLException ex) {

        realizarRollback(conn);

        throw new RuntimeException(
            "Erro ao adicionar professor: "
            + ex.getMessage(),
            ex
        );
    }
}
    public void removerProfessor(
        Connection conn,
        Professor professor) {

    String sql =
        "DELETE FROM disciplina_professor " +
        "WHERE codigo_disciplina = ? " +
        "AND matricula_professor = ?";

    try (PreparedStatement stmt =
             conn.prepareStatement(sql)) {

        stmt.setString(1, codigo);

        stmt.setInt(
            2,
            professor.getMatricula()
        );

        int linhas = stmt.executeUpdate();

        if (linhas == 0) {

            throw new RuntimeException(
                "Professor não vinculado à disciplina."
            );
        }

        professores.remove(professor);

        conn.commit();

    } catch (SQLException ex) {

        realizarRollback(conn);

        throw new RuntimeException(
            "Erro ao remover professor: "
            + ex.getMessage(),
            ex
        );
    }
}

    public void carregarProfessores(
            Connection conn) {

        String sql =
            "SELECT p.matricula, p.nome, p.idade " +
            "FROM professor p " +
            "JOIN disciplina_professor dp " +
            "ON p.matricula = dp.matricula_professor " +
            "WHERE dp.codigo_disciplina = ?";

        professores.clear();

        try (PreparedStatement stmt =
                 conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);

            try (ResultSet rs =
                     stmt.executeQuery()) {

                while (rs.next()) {

                    Professor p = new Professor();

                    p.setMatricula(
                        rs.getInt("matricula")
                    );

                    p.setNome(
                        rs.getString("nome")
                    );

                    p.setIdade(
                        rs.getInt("idade")
                    );

                    professores.add(p);
                }
            }

        } catch (SQLException ex) {

            throw new RuntimeException(
                "Erro ao carregar professores: "
                + ex.getMessage(),
                ex
            );
        }
    }

    // ==========================
    // LISTAR TODAS
    // ==========================

    public static ArrayList<Disciplina>
    buscarTodas(Connection conn) {

        String sql =
            "SELECT codigo, nome " +
            "FROM disciplina " +
            "ORDER BY nome";

        ArrayList<Disciplina> lista =
            new ArrayList<>();

        try (PreparedStatement stmt =
                 conn.prepareStatement(sql);

             ResultSet rs =
                 stmt.executeQuery()) {

            while (rs.next()) {

                Disciplina d = new Disciplina();

                d.setCodigo(
                    rs.getString("codigo")
                );

                d.setNome(
                    rs.getString("nome")
                );

                lista.add(d);
            }

        } catch (SQLException ex) {

            throw new RuntimeException(
                "Erro ao buscar disciplinas: "
                + ex.getMessage(),
                ex
            );
        }

        return lista;
    }

    // ==========================
    // ROLLBACK
    // ==========================

    private void realizarRollback(
            Connection conn) {

        try {

            if (conn != null) {
                conn.rollback();
            }

        } catch (SQLException ex) {

            System.err.println(
                "Erro crítico no rollback: "
                + ex.getMessage()
            );
        }
    }
}