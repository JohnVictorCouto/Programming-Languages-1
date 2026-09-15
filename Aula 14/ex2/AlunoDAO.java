import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

public class AlunoDAO {

    public Aluno lerDoBD(int loginId) {
        String sql = "SELECT * FROM tabela_notas WHERE login_id=?";
        Aluno aluno = new Aluno();

        try (Connection conn = ConnFactory.getConn();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, loginId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    for (int i = 0; i < 4; i++) {
                        String nome = rs.getString("materia_" + (i + 1));
                        if (nome == null) nome = "";
                        
                        double p1 = rs.getDouble("p1_" + (i + 1));
                        double p2 = rs.getDouble("p2_" + (i + 1));
                        double t1 = rs.getDouble("t1_" + (i + 1));
                        double p3 = rs.getDouble("p3_" + (i + 1));
                        double p4 = rs.getDouble("p4_" + (i + 1));
                        double t2 = rs.getDouble("t2_" + (i + 1));
                        int faltas = rs.getInt("faltas_" + (i + 1));

                        aluno.setMateria(i, new Materia(nome, p1, p2, p3, p4, t1, t2, faltas));
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + e.getMessage());
            e.printStackTrace();
        }

        return aluno;
    }

    public Timestamp getUltimaAlteracao(int loginId) {
        String sql = "SELECT ultima_alteracao FROM tabela_notas WHERE login_id=?";

        try (Connection conn = ConnFactory.getConn();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, loginId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getTimestamp("ultima_alteracao");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean salvar(Aluno aluno, int loginId) {
        String sql = "UPDATE tabela_notas SET " +
                "materia_1=?, p1_1=?, p2_1=?, t1_1=?, p3_1=?, p4_1=?, t2_1=?, faltas_1=?, " +
                "materia_2=?, p1_2=?, p2_2=?, t1_2=?, p3_2=?, p4_2=?, t2_2=?, faltas_2=?, " +
                "materia_3=?, p1_3=?, p2_3=?, t1_3=?, p3_3=?, p4_3=?, t2_3=?, faltas_3=?, " +
                "materia_4=?, p1_4=?, p2_4=?, t1_4=?, p3_4=?, p4_4=?, t2_4=?, faltas_4=?, " +
                "ultima_alteracao=NOW() WHERE login_id=?";

        try (Connection conn = ConnFactory.getConn();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            int p = 1;

            for (int i = 0; i < 4; i++) {
                Materia m = aluno.getMaterias().get(i);
                String nomeMateria = (m.getNome() == null || m.getNome().trim().isEmpty()) ? "Matéria " + (i + 1) : m.getNome();

                stmt.setString(p++, nomeMateria);
                stmt.setDouble(p++, m.getP1());
                stmt.setDouble(p++, m.getP2());
                stmt.setDouble(p++, m.getT1());
                stmt.setDouble(p++, m.getP3());
                stmt.setDouble(p++, m.getP4());
                stmt.setDouble(p++, m.getT2());
                stmt.setInt(p++, m.getFaltas());
            }

            stmt.setInt(p, loginId);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas >= 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar dados: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}