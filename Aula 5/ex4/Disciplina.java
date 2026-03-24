import javax.swing.JOptionPane;
public class Disciplina {
    // Atributos privados
    private String nome;
    private String professor;
    private int semestre;
    private boolean ofertada;

    // Construtor
    public Disciplina(String n, String p, int s, boolean o) {
        nome = n;
        professor = p;
        semestre = s;
        ofertada = o;
    }
    // Métodos de Acesso (Getters) e Modificadores (Setters)
    public String getNome() { // getter para nome
        return nome; // retorna o valor do atributo nome
    }
    public void setNome(String n) { // setter para nome
        nome = n; // atribui o valor do parâmetro n ao atributo nome
    }
    public String getProfessor() { // getter para professor
        return professor; // retorna o valor do atributo professor
    }
    public void setProfessor(String p) { // setter para professor
        professor = p; // atribui o valor do parâmetro p ao atributo professor
    }
    public int getSemestre() { // getter para semestre
        return semestre; // retorna o valor do atributo semestre
    }
    public void setSemestre(int s) { // setter para semestre
        semestre = s; // atribui o valor do parâmetro s ao atributo semestre
    }
    public boolean isOfertada() { // getter para ofertada
        return ofertada; // retorna o valor do atributo ofertada
    }
    public void setOfertada(boolean o) { // setter para ofertada
        ofertada = o; // atribui o valor do parâmetro o ao atributo ofertada
    }
    // Método para exibir os dados da disciplina
    public void exibirDados() {
        String status = ofertada ? "Sim" : "Não";
        JOptionPane.showMessageDialog(null, "--- Dados da Disciplina ---\nNome: " + nome + "\nProfessor: " + professor + "\nSemestre: " + semestre + "\nOfertada: " + status);
    }
}
