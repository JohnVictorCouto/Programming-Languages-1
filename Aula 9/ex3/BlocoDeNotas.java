import java.util.ArrayList;

public class BlocoDeNotas {
    // Atributo que armazena a lista de strings (notas)
    private ArrayList<String> notas;

    // Construtor: inicializa a lista de notas quando o objeto é criado
    public BlocoDeNotas() {
        this.notas = new ArrayList<>();
    }

    // Método para inserir uma nota na lista
    public void inserir(String nota) {
        // Verifica se a nota não é nula e não está apenas com espaços em branco
        if (nota != null && !nota.trim().isEmpty()) {
            notas.add(nota); // Adiciona a nota ao ArrayList
        }
    }

    // Método para remover uma nota com base na sua posição (índice)
    public boolean remover(int indice) {
        // Verifica se o índice existe dentro da lista
        if (indice >= 0 && indice < notas.size()) {
            notas.remove(indice); // Remove o item daquela posição
            return true; // Retorna verdadeiro se removeu
        }
        return false; // Retorna falso se o índice for inválido
    }

    // Método para modificar o texto de uma nota existente
    public boolean alterar(int indice, String novaNota) {
        // Verifica se o índice informado é válido
        if (indice >= 0 && indice < notas.size()) {
            notas.set(indice, novaNota); // Substitui o texto antigo pelo novo
            return true; // Sucesso
        }
        return false; // Falha
    }

    // Método que gera uma String formatada com todas as notas para exibição
    public String listarNotas() {
        // Se a lista estiver vazia, retorna um aviso
        if (notas.isEmpty()) {
            return "O bloco de notas está vazio.";
        }
        // StringBuilder é usado para concatenar strings de forma eficiente
        StringBuilder sb = new StringBuilder("--- Suas Notas ---\n");
        for (int i = 0; i < notas.size(); i++) {
            // Adiciona o índice e o conteúdo da nota, pulando uma linha (\n)
            sb.append(i).append(": ").append(notas.get(i)).append("\n");
        }
        return sb.toString(); // Converte o StringBuilder para String final
    }
}