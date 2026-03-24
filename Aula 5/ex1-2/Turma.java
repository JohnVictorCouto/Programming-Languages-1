import javax.swing.JOptionPane;

public class Turma {
    // Atributos privados
    private String nome;
    private String curso;
    private int quantidadeDeAlunos;
    private int serie;

    // Construtor
    public Turma(String n, String c, int q, int s) {
        nome = n;
        curso = c;
        quantidadeDeAlunos = q;
        serie = s;
    }
    // Métodos de Acesso (Getters) e Modificadores (Setters)
    public String getNome() { // getter para nome
        return nome; // retorna o valor do atributo nome
    } 
    public void setNome(String n) {  // setter para nome
        nome = n; // atribui o valor do parâmetro n ao atributo nome
    }

    public String getCurso() { // getter para curso
        return curso; // retorna o valor do atributo curso
    }
    public void setCurso(String c) { // setter para curso
        curso = c; // atribui o valor do parâmetro c ao atributo curso
    }

    public int getQuantidadeDeAlunos() { // getter para quantidade de alunos
        return quantidadeDeAlunos; // retorna o valor do atributo quantidadeDeAlunos
    }
    public void setQuantidadeDeAlunos(int q) { // setter para quantidade de alunos
        quantidadeDeAlunos = q; // atribui o valor do parâmetro q ao atributo quantidadeDeAlunos
    }

    public int getSerie() { // getter para série
        return serie; // retorna o valor do atributo série
    }
    public void setSerie(int s) { // setter para série
       serie = s; // atribui o valor do parâmetro s ao atributo série
    }

    // Método para exibir os dados da turma
    public void exibirDados() {
        JOptionPane.showMessageDialog(null, "--- Dados da Turma ---\nNome: " + nome + "\nCurso: " + curso + "\nSérie: " + serie + "\nQuantidade de Alunos: " + quantidadeDeAlunos);
    }
}