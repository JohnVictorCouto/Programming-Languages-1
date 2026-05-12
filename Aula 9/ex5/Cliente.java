public class Cliente {
    private String nome;
    private String fone;
    private int id;

    // Construtor que recebe todos os atributos
    public Cliente(int id, String nome, String fone) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
    }

    // Métodos de acesso (Getters) e modificadores (Setters)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getFone() { return fone; }
    public void setFone(String fone) { this.fone = fone; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Fone: " + fone;
    }
}