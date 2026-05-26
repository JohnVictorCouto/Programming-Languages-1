import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.ArrayList;

public class JavaMySqlApp {

    public static void main(String[] args) {

        String menu[] = {
            "Incluir Disciplina",
            "Consultar Disciplina",
            "Alterar Disciplina",
            "Excluir Disciplina",
            "Listar Disciplinas",
            "Vincular Professor",
            "Sair"
        };

        int opcao;

        do {

            opcao = JOptionPane.showOptionDialog(
                null,
                "Selecione uma opção:",
                "Sistema Acadêmico",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                menu,
                menu[6]
            );

            switch (opcao) {

                case 0:
                    incluirDisciplina();
                    break;

                case 1:
                    consultarDisciplina();
                    break;

                case 2:
                    alterarDisciplina();
                    break;

                case 3:
                    excluirDisciplina();
                    break;

                case 4:
                    listarDisciplinas();
                    break;

                case 5:
                    vincularProfessor();
                    break;

                case 6:
                case -1:
                    System.exit(0);
                    break;
            }

        } while (opcao != 6);
    }

    // ======================================
    // INCLUIR DISCIPLINA
    // ======================================

    private static void incluirDisciplina() {

        try (Connection conn =
                 ConnFactory.getConn()) {

            String codigo =
                JOptionPane.showInputDialog(
                    null,
                    "Código da disciplina:"
                );

            if (codigo == null ||
                codigo.trim().isEmpty()) {
                return;
            }

            String nome =
                JOptionPane.showInputDialog(
                    null,
                    "Nome da disciplina:"
                );

            if (nome == null ||
                nome.trim().isEmpty()) {
                return;
            }

            Disciplina disciplina =
                new Disciplina(
                    nome,
                    codigo,
                    new ArrayList<>()
                );

            disciplina.inserir(conn);

            JOptionPane.showMessageDialog(
                null,
                "Disciplina inserida!"
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                null,
                "Erro: " + ex.getMessage()
            );
        }
    }

    // ======================================
    // CONSULTAR DISCIPLINA
    // ======================================

    private static void consultarDisciplina() {

        try (Connection conn =
                 ConnFactory.getConn()) {

            String codigo =
                JOptionPane.showInputDialog(
                    null,
                    "Código da disciplina:"
                );

            if (codigo == null ||
                codigo.trim().isEmpty()) {
                return;
            }

            Disciplina disciplina =
                new Disciplina(codigo);

            boolean encontrada =
                disciplina.carregar(conn);

            if (encontrada) {

                disciplina.carregarProfessores(
                    conn
                );

                JOptionPane.showMessageDialog(
                    null,
                    disciplina
                );

            } else {

                JOptionPane.showMessageDialog(
                    null,
                    "Disciplina não encontrada."
                );
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                null,
                "Erro: " + ex.getMessage()
            );
        }
    }

    // ======================================
    // ALTERAR DISCIPLINA
    // ======================================

    private static void alterarDisciplina() {

        try (Connection conn =
                 ConnFactory.getConn()) {

            String codigo =
                JOptionPane.showInputDialog(
                    null,
                    "Código da disciplina:"
                );

            if (codigo == null ||
                codigo.trim().isEmpty()) {
                return;
            }

            String nome =
                JOptionPane.showInputDialog(
                    null,
                    "Novo nome:"
                );

            if (nome == null ||
                nome.trim().isEmpty()) {
                return;
            }

            Disciplina disciplina =
                new Disciplina(
                    nome,
                    codigo,
                    new ArrayList<>()
                );

            disciplina.alterar(conn);

            JOptionPane.showMessageDialog(
                null,
                "Disciplina alterada!"
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                null,
                "Erro: " + ex.getMessage()
            );
        }
    }

    // ======================================
    // EXCLUIR DISCIPLINA
    // ======================================

    private static void excluirDisciplina() {

        try (Connection conn =
                 ConnFactory.getConn()) {

            String codigo =
                JOptionPane.showInputDialog(
                    null,
                    "Código da disciplina:"
                );

            if (codigo == null ||
                codigo.trim().isEmpty()) {
                return;
            }

            Disciplina disciplina =
                new Disciplina(codigo);

            disciplina.excluir(conn);

            JOptionPane.showMessageDialog(
                null,
                "Disciplina excluída!"
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                null,
                "Erro: " + ex.getMessage()
            );
        }
    }

    // ======================================
    // LISTAR DISCIPLINAS
    // ======================================

    private static void listarDisciplinas() {

    try (Connection conn = ConnFactory.getConn()) {

        ArrayList<Disciplina> lista =
            Disciplina.buscarTodas(conn);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "Nenhuma disciplina cadastrada.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (Disciplina d : lista) {

            d.carregarProfessores(conn);

            sb.append("Código: ")
              .append(d.getCodigo())
              .append(" | Nome: ")
              .append(d.getNome())
              .append(" | Professores: ")
              .append(d.getProfessores())
              .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,
            "Erro: " + ex.getMessage());
    }
}

    // ======================================
    // VINCULAR PROFESSOR
    // ======================================

    private static void vincularProfessor() {

        try (Connection conn =
                 ConnFactory.getConn()) {

            String codigo =
                JOptionPane.showInputDialog(
                    null,
                    "Código da disciplina:"
                );

            if (codigo == null ||
                codigo.trim().isEmpty()) {
                return;
            }

            String matriculaTexto =
                JOptionPane.showInputDialog(
                    null,
                    "Matrícula do professor:"
                );

            if (matriculaTexto == null ||
                matriculaTexto.trim().isEmpty()) {
                return;
            }

            int matricula =
                Integer.parseInt(
                    matriculaTexto
                );

            // ==========================
            // CARREGA DISCIPLINA
            // ==========================

            Disciplina disciplina =
                new Disciplina(codigo);

            boolean existeDisciplina =
                disciplina.carregar(conn);

            if (!existeDisciplina) {

                JOptionPane.showMessageDialog(
                    null,
                    "Disciplina não encontrada."
                );

                return;
            }

            // ==========================
            // CARREGA PROFESSOR
            // ==========================

            Professor professor =
                new Professor(matricula);

            boolean existeProfessor =
                professor.carregar(conn);

            if (!existeProfessor) {

                JOptionPane.showMessageDialog(
                    null,
                    "Professor não encontrado."
                );

                return;
            }

            // ==========================
            // VINCULA
            // ==========================

            disciplina.adicionarProfessor(
                conn,
                professor
            );

            JOptionPane.showMessageDialog(
                null,
                "Professor vinculado!"
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                null,
                "Matrícula inválida."
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                null,
                "Erro: " + ex.getMessage()
            );
        }
    }
}