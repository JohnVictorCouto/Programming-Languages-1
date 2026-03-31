public class Atribuicao {
    private Professor professor; // Atributo para armazenar um objeto do tipo Professor 
    private Disciplina disciplina; // Atributo para armazenar um objeto do tipo Disciplina
    public Atribuicao(Professor professor, Disciplina disciplina) { // Construtor da classe Atribuicao
        this.professor = professor; // Atribuição do objeto Professor ao atributo professor
        this.disciplina = disciplina; // Atribuição do objeto Disciplina ao atributo disciplina
    }
    public Professor getProfessor() { // Método para obter o objeto Professor
        return professor;
    }
    public Disciplina getDisciplina() { // Método para obter o objeto Disciplina
        return disciplina;
    }
    public void setProfessor(Professor professor) { // Método para definir o objeto Professor
        this.professor = professor;
    }
    public void setDisciplina(Disciplina disciplina) { // Método para definir o objeto Disciplina
        this.disciplina = disciplina;
    }
    public String getDados() { // Método para exibir os dados da atribuição
        return "Atribuição [Professor=" + professor.getDados() + ", Disciplina=" + disciplina.getDados() + "]"; // Retorna uma string com os dados da atribuição
    }
}
