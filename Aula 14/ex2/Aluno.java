import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String usuario;
    private List<Materia> materias;

    public Aluno() {
        materias = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            materias.add(new Materia("", 0, 0, 0, 0, 0, 0, 0));
        }
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMateria(int index, Materia materia) {
        materias.set(index, materia);
    }
}