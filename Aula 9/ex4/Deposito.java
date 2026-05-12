import java.util.ArrayList;

public class Deposito {
    private ArrayList<Caixa> caixas;

    public Deposito() {
        this.caixas = new ArrayList<>();
    }

    // Adiciona uma caixa
    public void adicionarCaixa(Caixa c) {
        caixas.add(c);
    }

    // Encontra a posição no ArrayList pelo dono (retorna -1 se não achar)
    public int encontrarPosicaoPorDono(String dono) {
        for (int i = 0; i < caixas.size(); i++) {
            if (caixas.get(i).getDono().equalsIgnoreCase(dono)) {
                return i;
            }
        }
        return -1;
    }

    // Remove caixa pelo dono
    public boolean removerCaixa(String dono) {
        int index = encontrarPosicaoPorDono(dono);
        if (index != -1) {
            caixas.remove(index);
            return true;
        }
        return false;
    }

    // Muda corredor e posição encontrando pelo dono
    public boolean mudarCaixa(String dono, String novoCorredor, int novaPosicao) {
        int index = encontrarPosicaoPorDono(dono);
        if (index != -1) {
            caixas.get(index).setCorredor(novoCorredor);
            caixas.get(index).setPosicao(novaPosicao);
            return true;
        }
        return false;
    }

    // Retorna um VETOR com as caixas que pesam mais que o valor passado
    public Caixa[] getCaixasPesadas(double pesoMinimo) {
        ArrayList<Caixa> temporario = new ArrayList<>();
        for (Caixa c : caixas) {
            if (c.getPeso() > pesoMinimo) {
                temporario.add(c);
            }
        }
        // Converte o ArrayList temporário para um Vetor (Array) comum
        return temporario.toArray(new Caixa[0]);
    }
}
