import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.ArrayList;

public class JavaMySqlApp {

    public static void main(String args[]) {
        String sMenu[] = {"Incluir Professor", "Consultar Professor", "Alterar Professor", "Excluir Professor", "Listar Professores", "Sair"};
        int iOption;

        do {
            iOption = JOptionPane.showOptionDialog(
                null, 
                "Selecione uma opção:", 
                "Cadastro de Professores",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                sMenu, 
                sMenu[sMenu.length - 1]
            );

            switch(iOption) {
                case 0: incluirProfessor(); break;
                case 1: consultarProfessor(); break;
                case 2: alterarProfessor(); break;
                case 3: excluirProfessor(); break;
                case 4: listarProfessores(); break;
                case 5: case -1: // Caso clique em Sair ou feche a janela (X)
                    System.exit(0);
                    break;
            }
        } while(iOption != 5);
    }

    private static void incluirProfessor() {
        try(Connection conn = ConnFactory.getConn()) {
            int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Matrícula:", "Incluir Professor", JOptionPane.QUESTION_MESSAGE));
            String nome = JOptionPane.showInputDialog(null, "Digite o Nome:", "Incluir Professor", JOptionPane.QUESTION_MESSAGE);
            int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Idade:", "Incluir Professor", JOptionPane.QUESTION_MESSAGE));

            Professor professor = new Professor(nome, idade, matricula);
            professor.inserir(conn);
            JOptionPane.showMessageDialog(null, "Professor inserido:\n" + professor);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir professor: " + ex.getMessage());
        }
    }

    private static void consultarProfessor() {
        try(Connection conn = ConnFactory.getConn()) {
            int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Matrícula:", "Consultar Professor", JOptionPane.QUESTION_MESSAGE));
            Professor professor = new Professor(matricula);
            if(professor.carregar(conn)) {
                JOptionPane.showMessageDialog(null, "Professor encontrado:\n" + professor);
            } else {
                JOptionPane.showMessageDialog(null, "Professor não encontrado. Matrícula: " + matricula);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar professor: " + ex.getMessage());
        }
    }

    private static void alterarProfessor() {
        try(Connection conn = ConnFactory.getConn()) {
            int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Matrícula:", "Alterar Professor", JOptionPane.QUESTION_MESSAGE));
            String nome = JOptionPane.showInputDialog(null, "Digite o Novo Nome:", "Alterar Professor", JOptionPane.QUESTION_MESSAGE);
            int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Nova Idade:", "Alterar Professor", JOptionPane.QUESTION_MESSAGE));

            Professor professor = new Professor(nome, idade, matricula);
            professor.alterar(conn);
            JOptionPane.showMessageDialog(null, "Professor alterado:\n" + professor);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar professor: " + ex.getMessage());
        }
    }

    private static void excluirProfessor() {
        try(Connection conn = ConnFactory.getConn()) {
            int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Matrícula:", "Excluir Professor", JOptionPane.QUESTION_MESSAGE));
            Professor professor = new Professor(matricula);
            professor.excluir(conn);
            JOptionPane.showMessageDialog(null, "Professor excluído. Matrícula: " + matricula);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir professor: " + ex.getMessage());
        }
    }

    private static void listarProfessores() {
        try(Connection conn = ConnFactory.getConn()) {
            ArrayList<Professor> lista = Professor.buscarTodos(conn);
            if(lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum professor cadastrado.");
            } else {
                StringBuilder saida = new StringBuilder();
                for(Professor p : lista) {
                    saida.append(p).append("\n");
                }
                JOptionPane.showMessageDialog(null, saida.toString(), "Professores Cadastrados", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar professores: " + ex.getMessage());
        }
    }
}