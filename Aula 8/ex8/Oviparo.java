public class Oviparo extends Animal {
    private int numeroOvosPorPostura; // Número médio de ovos por postura
    private int tempoIncubacaoDias; // Tempo médio de incubação em dias

    public Oviparo(String nome, int patas, int numeroOvosPorPostura, int tempoIncubacaoDias) {
        super(patas, nome);
        this.numeroOvosPorPostura = numeroOvosPorPostura;
        this.tempoIncubacaoDias = tempoIncubacaoDias;
    }

    // Getters e setters
    public int getNumeroOvosPorPostura() {
        return numeroOvosPorPostura;
    }

    public void setNumeroOvosPorPostura(int numeroOvosPorPostura) {
        this.numeroOvosPorPostura = numeroOvosPorPostura;
    }

    public int getTempoIncubacaoDias() {
        return tempoIncubacaoDias;
    }

    public void setTempoIncubacaoDias(int tempoIncubacaoDias) {
        this.tempoIncubacaoDias = tempoIncubacaoDias;
    }
}