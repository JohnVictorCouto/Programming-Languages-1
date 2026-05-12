import java.util.ArrayList;

public class BancoDeClientes {
    private ArrayList<Cliente> clientes;

    public BancoDeClientes() {
        this.clientes = new ArrayList<>();
    }

    public void inserir(Cliente c) {
        clientes.add(c);
    }

    // Remove buscando pelo ID
    public boolean remover(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                clientes.remove(c);
                return true;
            }
        }
        return false;
    }

    public boolean alterar(int id, String novoNome, String novoFone) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                c.setNome(novoNome);
                c.setFone(novoFone);
                return true;
            }
        }
        return false;
    }

    // Lista dados de UM cliente específico pelo ID
    public String listarUm(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c.toString();
            }
        }
        return "Cliente não encontrado.";
    }

    // Lista dados de TODOS os clientes
    public String listarTodos() {
        if (clientes.isEmpty()) return "Banco vazio.";
        StringBuilder sb = new StringBuilder("--- Lista de Clientes ---\n");
        for (Cliente c : clientes) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}